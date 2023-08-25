public class Doll {
  private String name;
  private String material;
  private float price;

  public Doll(String name, String material, float price) {
    this.name = name;
    this.material = material;
    this.price = price;
  }

  public String toString() {
    return this.name;
  }

  public void displayInfo() {
    System.out.println("Name: " + this.name);
    System.out.println("Material: " + this.material);
    System.out.println("Price: $" + this.price);
  }

  public boolean isFragile() {
    return this.material == "porcelain" || this.material == "glass";
  }

  public void play() {
    System.out.println("I don't know. How to play");
  };
}

class Barbie extends Doll {
  public Barbie(String name, float price) {
    super(name, "Plastic", price);
  }

  public void play() {
    System.out.println("Barbie sings: I'm a Barbie girl in a Barbie world!");
  }
}

class TeddyDoll extends Doll {
  public TeddyDoll(String name, float price) {
    super(name, "Fabric", price);
  }

  public void play() {
    System.out.println("Teddy Doll says: Hug me!");
  }
}

class PorcelainDoll extends Doll {
  public PorcelainDoll(String name, float price) {
    super(name, "Porcelain", price);
  }

  public void play() {
    System.out.println("Porcelain Doll is delicate, be gentle!");
  }

}