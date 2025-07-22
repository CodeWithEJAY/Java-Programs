import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Weight Conversion Program
		
		double weight;
		double newWeight;
		int choice;
		
		System.out.println("Weight Conversion Program");
		System.out.println("[1] Convert pounds (lbs) to (kgs)");
		System.out.println("[2] Convert kilograms (kg) to pounds (lbs)");
		
		System.out.print("Choose an option: ");
		choice = scanner.nextInt();
		
		if (choice == 1) {
		    System.out.print("Enter the weight in pounds (lbs): ");
		    weight = scanner.nextDouble();
		    newWeight = weight * 0.453592;
		    System.out.printf("The new weight in kilograms (kgs) is: %.2f", newWeight);
		} else if (choice == 2) {
		    System.out.print("Enter the weight in kilograms (kgs): ");
		    weight = scanner.nextDouble();
		    newWeight = weight * 2.20462;
		    System.out.printf("The new weight in pounds (lbs) is: %.2f", newWeight);
		} else {
		    System.out.println("That was not a valid choice");
		}
		
		scanner.close();
	}
}
