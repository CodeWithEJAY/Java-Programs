import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double grade;
        double total = 0;

        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter grade " + i + ": ");
            grade = input.nextDouble();
            total = total + grade;
        }

        double average = total / 4;

        System.out.println("Average Grade: " + average);
    }
}
//  Create a program that will compute the average grade of 4 grades.
