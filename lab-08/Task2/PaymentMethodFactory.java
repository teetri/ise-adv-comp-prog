interface PaymentMethod {
  void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
  public void processPayment(double amount) {
    System.out.println(String.format("Processing credit card payment of $%.2f", amount));
  }
}

class PayPalPayment implements PaymentMethod {
  public void processPayment(double amount) {
    System.out.println(String.format("Processing PayPal payment of $%.2f", amount));
  }
}

class CryptoPayment implements PaymentMethod {
  public void processPayment(double amount) {
    System.out.println(String.format("Processing cryptocurrency payment of $%.2f", amount));
  }
}

public class PaymentMethodFactory {
  public PaymentMethod createPaymentMethod(String paymentType) {
    if (paymentType.equalsIgnoreCase("CREDIT CARD")) {
      return new CreditCardPayment();
    } else if (paymentType.equalsIgnoreCase("PAYPAL")) {
      return new PayPalPayment();
    } else if (paymentType.equalsIgnoreCase("CRYPTO")) {
      return new CryptoPayment();
    }
    return null;
  }
}
