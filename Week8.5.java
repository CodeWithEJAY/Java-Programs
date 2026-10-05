import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {5, 2, 5, 8, 5, 10, 2};

        System.out.print("Enter a number to count: ");
        int search = scanner.nextInt();

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == search) {
                count++;
            }
        }

        System.out.println("The number " + search + " appears " + count + " time(s) in the array.");

        scanner.close();
    }
}
// Count an Element
// Create a Java program that uses an array containing 5, 2, 5, 8, 5, 10, 2.
// Ask the user to enter a number and display how many times that number appears in the array.
