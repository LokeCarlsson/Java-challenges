package lc222ak_assign1;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) throws Error {
        System.out.println("Provide an odd integer!");
        Scanner inputText = new Scanner(System.in);
        String text = inputText.nextLine();
        int inputNumber = Integer.parseInt(text);
        if (inputNumber % 2 == 0) {
            throw new Error("Please provide an odd number!");
        }
        print(inputNumber);
        printNeg(inputNumber);
    }

    private static void print(int number) {
        for (int i = 0; i <= number; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < number - i; j+=2) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i; j++) {
                    if (i % 2 != 0)  {
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        }
    }

    private static void printNeg(int number) {
        for (int i = 1; i < number; i++) {
            if (i % 2 != 0) {
                for (int j = number; j > number - i; j-=2) {
                    System.out.print(" ");
                }
                for (int j = number - 1; j > i; j-=1) {
                    if (i % 2 != 0) {
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        }
    }
}
