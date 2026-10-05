import java.util.Scanner;

public class AverageNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers would you like to input? ");
        int n = input.nextInt();

        double sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            double number = input.nextDouble();

            sum += number;
        }

        double average = sum / n;

        System.out.println("Average: " + average);

        input.close();
    }
}
// AVERAGE OF n NUMBERS
// Create simple Java program that asks a user how many numbers they would like to input, 
// then enter those numbers one by one and take the average of those values.
