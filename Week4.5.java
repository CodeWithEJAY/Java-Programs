import java.util.Scanner;

public class Lab5_CircleRectangleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double PI = 3.14159;

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();

        double circleArea = PI * radius * radius;
        double circumference = 2 * PI * radius;

        double rectangleArea = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("\n===== RESULTS =====");
        System.out.println("Area of Circle: " + circleArea);
        System.out.println("Circumference of Circle: " + circumference);
        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Perimeter of Rectangle: " + perimeter);

        if (circleArea > rectangleArea) {
            System.out.println("The circle has a larger area.");
        } else if (rectangleArea > circleArea) {
            System.out.println("The rectangle has a larger area.");
        } else {
            System.out.println("The areas of the circle and rectangle are equal.");
        }

        scanner.close();
    }
}
// Combined Application - All Concepts
// Circle and Rectangle Calculator
