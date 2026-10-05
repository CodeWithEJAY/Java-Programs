import java.util.Scanner;

public class AverageThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = input.nextDouble();

        double average = (num1 + num2 + num3) / 3;

        System.out.println("Average: " + average);

        input.close();
    }
}
// AVERAGE OF 3 NUMBERS
// Create a Java program that calculates the average of 3 numbers. Ask a user to input those numbers
