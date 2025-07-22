import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String day;
		
		System.out.print("Enter the day of the week: ");
		day = scanner.nextLine().toLowerCase(); // convert input to lowercase

		switch (day) {
		    case "monday":
		        System.out.println(day + " is a weekday");
		        break;
		    case "tuesday":
		        System.out.println(day + " is a weekday");
		        break;
		    case "wednesday":
		        System.out.println(day + " is a weekday");
		        break;
		    case "thursday":
		        System.out.println(day + " is a weekday");
		        break;
		    case "friday":
		        System.out.println(day + " is a weekday");
		        break;
		    case "saturday":
		        System.out.println(day + " is a weekend");
		        break;
		    case "sunday":
		        System.out.println(day + " is a weekend");
		        break;
		    default:
		        System.out.println(day + " is not a day");
		        break;
		}
		scanner.close();
	}
}
