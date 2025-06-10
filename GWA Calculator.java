import java.util.Scanner;

public class GwaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalWeightedGrades = 0;
        double totalUnits = 0;

        System.out.println("Welcome to the GWA Calculator!");
        System.out.println("Enter your grades and units for each subject.");
        System.out.println("Type 'done' when you're finished.\n");

        while (true) {
            System.out.print("Enter your grade: ");
            String gradeInput = scanner.nextLine().trim().toUpperCase();

            if (gradeInput.equals("DONE")) {
                break;
            }

            if (gradeInput.equals("INC") || gradeInput.equals("DRP")) {
                System.out.println("Grade status: " + gradeInput + "\n");
                continue;
            }

            double grade;
            try {
                grade = Double.parseDouble(gradeInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input. Try again.\n");
                continue;
            }

            if (grade < 1.00 || grade > 5.00) {
                System.out.println("Grade out of range. Must be between 1.00 and 5.00.\n");
                continue;
            }

            System.out.print("Enter units earned for this subject: ");
            double units;
            try {
                units = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid units. Try again.\n");
                continue;
            }

            if (units <= 0) {
                System.out.println("Units must be greater than zero.\n");
                continue;
            }

            String status = getStatus(grade); // Line 65 now works
            System.out.println("Grade status: " + status + "\n");

            totalWeightedGrades += grade * units;
            totalUnits += units;
        }

        if (totalUnits > 0) {
            double gwa = totalWeightedGrades / totalUnits;
            System.out.printf("\nYour General Weighted Average (GWA) is: %.2f\n", gwa);
        } else {
            System.out.println("\nNo valid grades entered to compute GWA.");
        }
    }

    public static String getStatus(double grade) {
        if (grade == 1.00 || grade == 1.25)
            return "Excellent";
        else if (grade == 1.50 || grade == 1.75)
            return "Very Satisfactory";
        else if (grade == 2.00 || grade == 2.25)
            return "Satisfactory";
        else if (grade == 2.50 || grade == 2.75 || grade == 3.00)
            return "Fairly Satisfactory";
        else if (grade == 4.00)
            return "Conditional Failure";
        else
            return "Failed";
    }
}
