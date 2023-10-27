interface ShapeStrategy {
    double calculateArea();
}

class CircleStrategy implements ShapeStrategy {
    private double radius;

    public CircleStrategy(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class QuadilateralStrategy implements ShapeStrategy {
    private double width;
    private double height;

    public QuadilateralStrategy(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

class Shape {
    protected ShapeStrategy shapeStrategy;

    double getArea() {
        return shapeStrategy.calculateArea();
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setShapeStrategy(ShapeStrategy shapeStrategy) {
        super.shapeStrategy = new shapeStrategy(this.radius);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Shape c = new Circle(3);
        c.shapeStrategy(CircleStrategy);

    }
}
