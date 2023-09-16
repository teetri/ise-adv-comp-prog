public interface DiscountStrategy {
  double applyDiscount(double price);
}

class NoDiscountStrategy implements DiscountStrategy {
  public NoDiscountStrategy() {
  }

  public double applyDiscount(double price) {
    return price;
  }

}

class PercentageDiscountStrategy implements DiscountStrategy {
  private double percentageDiscount;

  public PercentageDiscountStrategy(double percentageDiscount) {
    this.percentageDiscount = percentageDiscount;
  }

  public double applyDiscount(double price) {
    return price * (100 - this.percentageDiscount) / 100;
  }

}

class FixedDiscountStrategy implements DiscountStrategy {
  private double fixedDiscount;

  public FixedDiscountStrategy(double fixedDiscount) {
    this.fixedDiscount = fixedDiscount;
  }

  public double applyDiscount(double price) {
    return price - this.fixedDiscount;
  }

}