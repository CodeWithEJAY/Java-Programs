import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String username;
        String password;

        while (true) {
            System.out.print("Enter username: ");
            username = input.nextLine();

            System.out.print("Enter password: ");
            password = input.nextLine();

            if (username.equals("5555") && password.equals("1234")) {
                System.out.println("Success!");
                break;
            } else {
                System.out.println("Incorrect username or password.");
            }
        }
    }
}
// Create a program that enter username and password and that will show incorrect username or password if the combination of user and pass is incorrect. 
// Set the username 5555 and password as 1234, if the username and password are correct show “success!”
