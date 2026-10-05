public class Main {
    public static void main(String[] args) {

        int[] numbers = {4, 2, 6, 22, 33};

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            sum = sum + numbers[i];
        }

        numbers[4] = sum;

        System.out.println("Sum stored in index [4]: " + numbers[4]);
    }
}
// Create a Java program that adds all the elements of an array and stores the sum in the last element (index [4]).
