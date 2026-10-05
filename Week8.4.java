import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 25, 15, 30, 45};

        System.out.print("Enter a number to search: ");
        int search = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == search) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Number is found in the array.");
        } else {
            System.out.println("Number is not found in the array.");
        }

        scanner.close();
    }
}
// Search an Element
// Create a Java program that uses an array containing 10, 25, 15, 30, 45. 
// Ask the user to enter a number and display whether the number is found or not found in the array.
