public class Lab4_6538075121 {
    public static void main(String[] args) throws Exception {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Square("Red", 5);
        shapes[1] = new Square("Blue", 3);
        shapes[2] = new Rectangle("Green", 4, 6);
        shapes[3] = new Rectangle("Yellow", 2, 8);
        shapes[4] = new Circle("Orange", 7);

        for (Shape shape : shapes) {
            System.out.println(String.format("Shape: %s", shape.getClass().getSimpleName()));
            shape.printDetails();
            System.out.println("----------------------");
        }
    }
}

abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public abstract double getArea();

    public abstract void printDetails();

    public abstract void resize(double factor);
}

class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public void printDetails() {
        System.out.println("Color: " + super.getColor());
        System.out.println("Side Length: " + this.side);
        System.out.println("Area: " + this.getArea());
    }

    @Override
    public void resize(double factor) {
        this.side *= factor;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public void printDetails() {
        System.out.println("Color: " + super.getColor());
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("Area: " + this.getArea());
    }

    @Override
    public void resize(double factor) {
        this.width *= factor;
        this.height *= factor;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public void printDetails() {
        System.out.println("Color: " + super.getColor());
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + this.getArea());
    }

    @Override
    public void resize(double factor) {
        this.radius *= factor;
    }
}