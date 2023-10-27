import java.util.List;
import java.util.ArrayList;

class ShoppingCart {
    private List<String> items;
    private double deliveryFee = 0;

    public ShoppingCart() {
        this.items = new ArrayList<String>();
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void addDeliveryFee(double fee) {
        this.deliveryFee = fee;
    }

    public double getDeliveryFee() {
        return this.deliveryFee;
    }

    public double calculateTotal() {
        double total = 0;
        for (String item : this.items) {
            total += Double.parseDouble(item.split(":")[1]) * Double.parseDouble(item.split(":")[2]);
        }
        return total;
    }

    public double getNetPrice() {
        return this.calculateTotal() + this.deliveryFee;
    }

}

class ShoppingCartDecorator extends ShoppingCart {
    protected ShoppingCart cart;

    public ShoppingCartDecorator(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public double calculateTotal() {
        return cart.calculateTotal();
    }

    @Override
    public double getNetPrice() {
        return cart.getNetPrice();
    }

    @Override
    public double getDeliveryFee() {
        return cart.getDeliveryFee();
    }

}

class DiscountByPercentDecorator extends ShoppingCartDecorator {
    private double discount;

    public DiscountByPercentDecorator(ShoppingCart cart, double discount) {
        super(cart);
        this.discount = discount;
    }

    @Override
    public double getNetPrice() {
        return ((100 - this.discount) / 100) * (this.cart.calculateTotal())
                + this.getDeliveryFee();
    }
}

class DiscountByAmountDecorator extends ShoppingCartDecorator {
    private double discount;

    public DiscountByAmountDecorator(ShoppingCart cart, double discount) {
        super(cart);
        this.discount = discount;
    }

    @Override
    public double getNetPrice() {
        return this.cart.getNetPrice() - this.discount;
    }
}

class FreeDeliveryDecorator extends ShoppingCartDecorator {

    public FreeDeliveryDecorator(ShoppingCart cart) {
        super(cart);
    }

    @Override
    public double getNetPrice() {
        return this.cart.getNetPrice() - this.getDeliveryFee();
    }

}

public class App {

    public static void main(String[] args) throws Exception {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem("Item1:2:50.0"); // net price is 100.0
        cart.addItem("Item2:1:30.0"); // net price is 130.0

        // Add delivery fee
        cart.addDeliveryFee(10); // Add a $10 delivery fee

        // Apply coupons using decorators
        cart = new DiscountByPercentDecorator(cart, 10.0); // Apply a 10% discount, net price should be 127.0
        // (130*0.9+10)

        cart = new FreeDeliveryDecorator(cart); // Apply free delivery, net price now is 117.0

        // Calculate and display the total price and net price
        double total = cart.calculateTotal();
        double netPrice = cart.getNetPrice();
        System.out.println("Total Price: $" + total);
        System.out.println("Net Price: $" + netPrice);
    }
}
