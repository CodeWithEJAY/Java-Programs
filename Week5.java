import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Name: Erickson Joseph Kristoffer Luna
        // Section: BSCS - 2A

        Scanner scanner = new Scanner(System.in);

        // Ask for the number of students
        System.out.print("How many students? ");
        int numOfStudents = scanner.nextInt();

        // Variables for the summary
        int passedStudents = 0;
        int failedStudents = 0;
        int totalScore = 0;

        // Process each student's score using a for and while loop
        for (int studentNumber = 1; studentNumber <= numOfStudents; studentNumber++) {

            int score;

            // Validate the score using an inner loop
            while (true) {
                System.out.print("\nEnter the score of the student " + studentNumber + ": ");
                score = scanner.nextInt();

                if (score >= 0 && score <= 100) {
                    break;
                } else {
                    System.out.println("Invalid score! Please enter a valid score between 0 and 100.");
                }
            }

            // Variable for the letter grade
            char grade;

            // Determine the letter grade using if-else
            if (score >= 90) {
                grade = 'A';
            } else if (score >= 80) {
                grade = 'B';
            } else if (score >= 70) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display the student's score and grade
            System.out.println("Score: " + score + " → Grade: " + grade);

            // Add the score to the total
            totalScore += score;

            // Count passed and failed students
            if (grade == 'F') {
                failedStudents++;
            } else {
                passedStudents++;
            }
        }

        // Calculate the class average
        double classAverage = (double) totalScore / numOfStudents;

        // Display the summary
        System.out.println("\n===== SUMMARY =====");
        System.out.println("Total students : " + numOfStudents);
        System.out.println("Passed         : " + passedStudents);
        System.out.println("Failed         : " + failedStudents);
        System.out.printf("Class average  : %.2f%n", classAverage);

        scanner.close();
    }
}
// Write a Java program that processes scores for a group of students. 
// The program must use both selection and repetition control structures working together.
