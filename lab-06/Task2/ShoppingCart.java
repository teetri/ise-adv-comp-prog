class ShoppingCart {
  private Item[] items;
  private DiscountStrategy discountStrategy;

  public ShoppingCart() {
    this.items = new Item[0];
    this.discountStrategy = new NoDiscountStrategy(); // Default strategy
  }

  public void setDiscountStrategy(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public void addItem(Item item) {
    // Extend the array to accommodate the new item
    Item[] newItems = new Item[this.items.length + 1];
    for (int i = 0; i < this.items.length; i++) {
      newItems[i] = this.items[i];
    }
    newItems[this.items.length] = item;
    this.items = newItems;
  }

  public double calculateTotal() {
    double total = 0;
    for (Item item : this.items) {
      total += item.getPrice() * item.getQuantity();
    }
    return this.discountStrategy.applyDiscount(total);
  }
}