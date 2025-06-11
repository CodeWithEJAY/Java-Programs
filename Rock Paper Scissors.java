import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            String player = "";
            String computer = "";
            String answer = "";

            System.out.println("=============ROCK-PAPER-SCISSORS=============");
            System.out.println("[1] ROCK");
            System.out.println("[2] PAPER");
            System.out.println("[3] SCISSORS");

            int playerChoice = 0;
            while (playerChoice < 1 || playerChoice > 3) {
                System.out.print("Enter your choice: ");
                try {
                    playerChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                }
            }

            switch (playerChoice) {
                case 1:
                    player = "ROCK";
                    break;
                case 2:
                    player = "PAPER";
                    break;
                case 3:
                    player = "SCISSORS";
                    break;
            }

            int computerChoice = random.nextInt(3) + 1;
            switch (computerChoice) {
                case 1:
                    computer = "ROCK";
                    break;
                case 2:
                    computer = "PAPER";
                    break;
                case 3:
                    computer = "SCISSORS";
                    break;
            }

            System.out.println();
            System.out.println("Player 1: " + player);
            System.out.println("Player 2: " + computer);
            System.out.println();

            if (player.equals(computer)) {
                System.out.println("It's a draw!");
            } else if ((player.equals("ROCK") && computer.equals("SCISSORS")) ||
                       (player.equals("PAPER") && computer.equals("ROCK")) ||
                       (player.equals("SCISSORS") && computer.equals("PAPER"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }

            System.out.println();
            System.out.print("Would you like to play again (Y/N): ");
            answer = scanner.nextLine().toUpperCase();
            System.out.println();

            if (!answer.equals("Y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
