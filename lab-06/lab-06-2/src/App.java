public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Widget", 3, 10.99);
        Item item2 = new Item("Gadget", 2, 19.99);

        cart.addItem(item1);
        cart.addItem(item2);

        System.out.println("No discount:");
        System.out.printf("%.2f\n", cart.calculateTotal());

        // Your cart should set different discount strategies and display the total cost
        // after discount.
        System.out.println("Discounted by 20%:");
        cart.setDiscountStrategy(new PercentageDiscountStrategy(20));
        System.out.printf("%.2f\n", cart.calculateTotal());

        System.out.println("Discounted by 20:");
        cart.setDiscountStrategy(new FixedDiscountStrategy(20));
        System.out.printf("%.2f\n", cart.calculateTotal());
    }
}