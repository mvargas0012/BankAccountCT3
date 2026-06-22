package bankaccountgui3;

import java.util.Scanner;

public class RecursiveProduct {

    // Recursive method to calculate product
    public static int findProduct(int[] numbers, int index) {

        // Base case
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Recursive case
        return numbers[index] * findProduct(numbers, index + 1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter five numbers:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        int product = findProduct(numbers, 0);

        System.out.println("\nProduct of all five numbers: " + product);

        input.close();
    }
}

