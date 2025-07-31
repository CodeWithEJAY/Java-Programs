import java.util.*;
import java.util.concurrent.*;

public class Main {

    // ---------------- Configuration ----------------
    private static final int TIME_LIMIT_SECONDS = 15;  // time per question
    private static final int STARTING_LIVES = 5;       // number of lives
    private static final boolean SHUFFLE_QUESTIONS = true;
    private static final boolean SHUFFLE_OPTIONS = true;
    // ------------------------------------------------

    private static final String LINE = "-------------------------------------------------------";
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        println(LINE);
        println("Chemistry Quiz  |  " + TIME_LIMIT_SECONDS + "s/question  |  Lives: " + STARTING_LIVES);
        println("Type A, B, C, or D. Press Enter to submit.");
        println("You lose a life for a wrong answer or if time runs out.");
        println(LINE);

        List<Question> bank = buildQuestionBank();

        if (SHUFFLE_QUESTIONS) {
            Collections.shuffle(bank, new Random());
        }

        int lives = STARTING_LIVES;
        int score = 0;
        int qNumber = 0;

        for (Question q : bank) {
            qNumber++;
            boolean correct = askQuestion(q, qNumber, bank.size());
            if (correct) {
                score++;
                println("\n✅ Correct! Score: " + score + " | Lives: " + hearts(lives));
            } else {
                lives--;
                println("\n❌ Incorrect. Correct answer: " + q.correctLetter() + ") " + q.correctText());
                println("Score: " + score + " | Lives: " + hearts(lives));
                if (lives <= 0) {
                    println(LINE);
                    println("Game over! You ran out of lives.");
                    break;
                }
            }
            println(LINE);
        }

        println("Final Score: " + score + " / " + bank.size());
        if (lives > 0) {
            println("Great job! You finished with " + lives + " " + (lives == 1 ? "life" : "lives") + " remaining.");
        }
        println("Thanks for playing!");
    }

    private static boolean askQuestion(Question q, int number, int total) {
        if (SHUFFLE_OPTIONS) q.shuffleOptions();

        println("Q" + number + "/" + total + ": " + q.prompt);
        char[] letters = new char[] {'A', 'B', 'C', 'D'};
        for (int i = 0; i < q.options.size(); i++) {
            println("  " + letters[i] + ") " + q.options.get(i));
        }
        System.out.print("\nAnswer (A-D): ");

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Input thread
        Future<String> inputFuture = executor.submit(() -> SC.nextLine().trim());

        // Timer thread: visible countdown
        Future<?> timerFuture = executor.submit(() -> {
            try {
                for (int i = TIME_LIMIT_SECONDS; i >= 0; i--) {
                    System.out.print("\r⏳ Time left: " + i + "s   ");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignored) {}
        });

        String input = null;
        try {
            input = inputFuture.get(TIME_LIMIT_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.print("\r⏳ Time left: 0s   ");
            println("\n⏰ Time's up!");
            inputFuture.cancel(true);
            executor.shutdownNow();
            return false;
        } catch (Exception ignored) {}

        timerFuture.cancel(true);
        executor.shutdownNow();

        if (input == null || input.isEmpty()) return false;

        char ans = Character.toUpperCase(input.charAt(0));
        int idx = letterToIndex(ans);
        return idx == q.correctIndex;
    }

    private static int letterToIndex(char c) {
        switch (Character.toUpperCase(c)) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            default:  return -1;
        }
    }

    private static String hearts(int lives) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lives; i++) sb.append("❤");
        for (int i = lives; i < STARTING_LIVES; i++) sb.append("♡");
        return sb.toString();
    }

    private static void println(String s) { System.out.println(s); }

    // ---------------- Question Bank ----------------
    private static List<Question> buildQuestionBank() {
        List<Question> list = new ArrayList<>();

        list.add(q("What is the chemical symbol for Sodium?",
                opts("Na", "So", "Sd", "Sn"), 0));
        list.add(q("Which element has the atomic number 1?",
                opts("Helium", "Hydrogen", "Lithium", "Oxygen"), 1));
        list.add(q("Which element is a halogen?",
                opts("Neon", "Chlorine", "Argon", "Krypton"), 1));
        list.add(q("What is the lightest noble gas?",
                opts("Neon", "Argon", "Helium", "Radon"), 2));
        list.add(q("Which element has the symbol 'Fe'?",
                opts("Fluorine", "Fermium", "Iron", "Francium"), 2));
        list.add(q("Which element is liquid at room temperature?",
                opts("Mercury", "Sodium", "Aluminum", "Calcium"), 0));
        list.add(q("What is the chemical symbol for Potassium?",
                opts("P", "Po", "K", "Pt"), 2));
        list.add(q("Which element is commonly used in light bulb filaments?",
                opts("Tungsten", "Silver", "Copper", "Nickel"), 0));
        list.add(q("Which element has the atomic number 8?",
                opts("Nitrogen", "Oxygen", "Fluorine", "Neon"), 1));
        list.add(q("Which element is most abundant in Earth’s atmosphere?",
                opts("Nitrogen", "Oxygen", "Argon", "Carbon Dioxide"), 0));
        list.add(q("Which element has the symbol 'Ag'?",
                opts("Argon", "Silver", "Gold", "Gallium"), 1));
        list.add(q("Which element's symbol is 'Pb'?",
                opts("Lead", "Platinum", "Palladium", "Polonium"), 0));
        list.add(q("Which element has the atomic number 6?",
                opts("Carbon", "Nitrogen", "Boron", "Oxygen"), 0));
        list.add(q("Which element is a metalloid?",
                opts("Silicon", "Sodium", "Calcium", "Neon"), 0));
        list.add(q("Which element has the symbol 'Cu'?",
                opts("Copper", "Curium", "Cobalt", "Carbon"), 0));
        list.add(q("What is the most reactive group of metals?",
                opts("Transition metals", "Alkaline earth metals", "Lanthanides", "Alkali metals"), 3));
        list.add(q("Which element has the symbol 'N'?",
                opts("Neon", "Nitrogen", "Nickel", "Niobium"), 1));
        list.add(q("Which element is known as quicksilver?",
                opts("Mercury", "Silver", "Gallium", "Bromine"), 0));
        list.add(q("Which element has the symbol 'Au'?",
                opts("Silver", "Gold", "Argon", "Astatine"), 1));
        list.add(q("Which element is needed for hemoglobin in blood?",
                opts("Potassium", "Iron", "Calcium", "Zinc"), 1));
        list.add(q("Which of these is an alkaline earth metal?",
                opts("Magnesium", "Sodium", "Aluminum", "Manganese"), 0));
        list.add(q("Which element has the symbol 'Si'?",
                opts("Sulfur", "Silicon", "Selenium", "Samarium"), 1));
        list.add(q("Which element has the lowest atomic number among the halogens?",
                opts("Fluorine", "Chlorine", "Bromine", "Iodine"), 0));
        list.add(q("Which element is used in pencils (as 'lead')?",
                opts("Lead", "Graphite (Carbon)", "Tin", "Antimony"), 1));
        list.add(q("Which element has the symbol 'Hg'?",
                opts("Holmium", "Mercury", "Hafnium", "Hassium"), 1));
        list.add(q("What is the chemical symbol for Calcium?",
                opts("Cl", "Ca", "Cs", "C"), 1));
        list.add(q("Which element is a noble gas?",
                opts("Xenon", "Boron", "Phosphorus", "Iodine"), 0));
        list.add(q("Which element has the symbol 'Zn'?",
                opts("Zirconium", "Zinc", "Zein", "Zenon"), 1));
        list.add(q("Which element is commonly used in semiconductor chips?",
                opts("Boron", "Silicon", "Germanium", "Gallium"), 1));
        list.add(q("Which element has the symbol 'K'?",
                opts("Krypton", "Potassium", "Kelvin", "Kallium"), 1));

        return list;
    }

    private static Question q(String prompt, List<String> options, int correctIndex) {
        return new Question(prompt, options, correctIndex);
    }

    private static List<String> opts(String a, String b, String c, String d) {
        return new ArrayList<>(Arrays.asList(a, b, c, d));
    }

    // ---------------- Model ----------------
    private static class Question {
        String prompt;
        List<String> options; // size 4
        int correctIndex;     // 0..3

        Question(String prompt, List<String> options, int correctIndex) {
            this.prompt = prompt;
            this.options = options;
            this.correctIndex = correctIndex;
        }

        void shuffleOptions() {
            String correct = options.get(correctIndex);
            List<String> shuffled = new ArrayList<>(options);
            Collections.shuffle(shuffled, new Random());
            this.options = shuffled;
            this.correctIndex = options.indexOf(correct);
        }

        String correctText() { return options.get(correctIndex); }

        String correctLetter() {
            return "" + (char)('A' + correctIndex);
        }
    }
}
