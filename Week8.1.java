public class Main {
    public static void main(String[] args) {

        int[] numbers = {4, 2, 6, 22, 33};

        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("Maximum value: " + max);
    }
}
// Create a Java program that initializes an array with the values 4, 2, 6, 22, 33 and displays the maximum value in the array.
