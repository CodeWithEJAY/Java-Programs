import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Circumference = 2 * Math.PI * radius;
		// Area = Math.PI * Math.pow(radius, 2);
		// Volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		
		double radius;
		double circumference;
		double area;
		double volume;
		
		System.out.print("Enter the radius: ");
		radius = scanner.nextDouble();
		
		circumference = 2 * Math.PI * radius;
		System.out.printf("The circumference is: %.2fcm\n", circumference);
		
		area = Math.PI * Math.pow(radius, 2);
		System.out.printf("The area is: %.2fcm^2\n" , area);
		
		volume = (4.0 / 3.0 ) * Math.PI * Math.pow(radius, 3);
		System.out.printf("The volume is: %.2fcm^3\n", volume);
		
		
		scanner.close();
	}
}
