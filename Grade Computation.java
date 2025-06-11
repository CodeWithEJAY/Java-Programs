import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GradeComputation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Declare variables
        float mLect, mLab, fLect, fLab;
        float mGrade, fGrade, semGrade;

        // Midterm Grades Input
        System.out.println("———————MIDTERM PERIOD———————");
        System.out.print("Enter Midterm Lecture Grade: ");
        mLect = Float.parseFloat(reader.readLine());

        System.out.print("Enter Midterm Lab Grade: ");
        mLab = Float.parseFloat(reader.readLine());

        mGrade = (0.6f * mLect) + (0.4f * mLab);
        System.out.println("Midterm Grade is " + String.format("%.2f", mGrade));

        // Final Grades Input
        System.out.println("\n———————FINAL PERIOD———————");
        System.out.print("Enter Final Lecture Grade: ");
        fLect = Float.parseFloat(reader.readLine());

        System.out.print("Enter Final Lab Grade: ");
        fLab = Float.parseFloat(reader.readLine());

        fGrade = (0.6f * fLect) + (0.4f * fLab);
        System.out.println("Final Grade is " + String.format("%.2f", fGrade));

        // Semester Grade Calculation
        semGrade = (mGrade + fGrade) / 2;

        // Display Summary
        System.out.println("\n———————SUMMARY———————");
        System.out.println("PERIOD\t\tLECTURE\tLAB\tGRADE");
        System.out.println("Midterm\t\t" + String.format("%.2f", mLect) + "\t" +
                           String.format("%.2f", mLab) + "\t" + String.format("%.2f", mGrade));
        System.out.println("Final\t\t" + String.format("%.2f", fLect) + "\t" +
                           String.format("%.2f", fLab) + "\t" + String.format("%.2f", fGrade));
        System.out.println("Sem Grade\t\t\t\t" + String.format("%.2f", semGrade));
        System.out.println("———————————————");
    }
}
