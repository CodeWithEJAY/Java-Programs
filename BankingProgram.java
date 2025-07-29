import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // JAVA BANKING PROGRAM 

        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            System.out.println("                ");
            System.out.println("        BANKING PROGRAM        ");
            System.out.println("                ");
            System.out.println("[1] Show Balance");
            System.out.println("[2] Deposit");
            System.out.println("[3] Withdraw");
            System.out.println("[4] Exit");
            System.out.println("                ");

            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    balance += deposit();
                    break;
                case 3:
                    balance -= withdraw(balance);
                    break;
                case 4:
                    System.out.print("Are you sure you want to exit? (y/n): ");
                    char confirm = scanner.next().charAt(0);
                    if (confirm == 'y' || confirm == 'Y') {
                        isRunning = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number from 1 to 4.");
                    break;
            }
        }

        System.out.println("              ");
        System.out.println(" Thank you! Have a nice day! 😊");
        System.out.println("              ");

        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.println("\nYour current balance is: ₱" + String.format("%.2f", balance));
    }

    static double deposit() {
        double amount;

        System.out.print("Enter an amount to be deposited: ₱");
        amount = scanner.nextDouble();

        if (amount < 0) {
            System.out.println("Amount can't be negative!");
            return 0;
        } else {
            System.out.println("Successfully deposited ₱" + String.format("%.2f", amount));
            return amount;
        }
    }

    static double withdraw(double balance) {
        double amount;

        System.out.print("Enter amount to be withdrawn: ₱");
        amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient Funds!");
            return 0;
        } else if (amount < 0) {
            System.out.println("Amount can't be negative!");
            return 0;
        } else {
            System.out.println("Successfully withdrew ₱" + String.format("%.2f", amount));
            return amount;
        }
    }
}
