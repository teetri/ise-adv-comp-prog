interface PaymentMethod {
  void processPayment(double amount);
}

interface PaymentMethodFactory {
  PaymentMethod createPaymentMethod();
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

class CreditCardPaymentFactory implements PaymentMethodFactory {
  public PaymentMethod createPaymentMethod() {
    return new CreditCardPayment();
  }
}

class PayPalPaymentFactory implements PaymentMethodFactory {
  public PaymentMethod createPaymentMethod() {
    return new PayPalPayment();
  }
}

class CryptoPaymentFactory implements PaymentMethodFactory {
  public PaymentMethod createPaymentMethod() {
    return new CryptoPayment();
  }
}