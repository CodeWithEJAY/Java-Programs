import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user for radius
        System.out.print("Enter the radius of the circle: ");
        double radius = input.nextDouble();

        // Calculate area
        double area = Math.PI * radius * radius;

        // Display result
        System.out.println("The area of the circle is: " + area);
    }
}
