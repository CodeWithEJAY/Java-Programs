import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];
        int sum = 0;
        double average;

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();

            sum = sum + numbers[i];
        }

        average = (double) sum / 5;

        System.out.println("\nSum: " + sum);
        System.out.println("Average: " + average);

        input.close();
    }
}
// Create a Java program that finds the sum and average of all elements in an array of size 5.
// Use the Scanner class to accept the array elements from the user.
