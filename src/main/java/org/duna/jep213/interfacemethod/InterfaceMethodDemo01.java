package org.duna.jep213.interfacemethod;

public class InterfaceMethodDemo01 {
  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(2, 3);
    double rectanglePerimeter = rectangle.calculatePerimeter();
    System.out.println("Rectangle Perimeter " + rectanglePerimeter);
    double rectangleArea = rectangle.rectangleArea(2, 3);
    System.out.println("Rectangle Area " + rectangleArea);

    Square square = new Square(4);
    double squarePerimeter = square.calculatePerimeter();
    System.out.println("Square Perimeter " + squarePerimeter);
    double squareArea = square.squareArea(4);
    System.out.println("Square Area " + squareArea);
  }
}

interface Figure {
  double calculatePerimeter();

  default double squareArea(double side) {
    return calculateRectangleArea(side, side);
  }

  default double rectangleArea(double base, double height) {
    return calculateRectangleArea(base, height);
  }

  //Java 9 introduced the JEP 213 feature, which allows interfaces to have private methods.
  //This improves code organization, encapsulation, and code reuse.
  private double calculateRectangleArea(double side, double height) {
    return side * height;
  }

}

class Rectangle implements Figure {
  private double base;
  private double height;

  public Rectangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * (base + height);
  }
}

class Square implements Figure {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double calculatePerimeter() {
    return 4 * side;
  }
}



