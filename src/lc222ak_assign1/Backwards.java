package lc222ak_assign1;

import java.util.Scanner;

public class Backwards {
    public static void main(String[] args) throws Error {
        Scanner inputText = new Scanner(System.in);
        String inputString = inputText.nextLine();

        String outputText = new StringBuilder(inputString).reverse().toString();

        System.out.print(outputText);
    }
}
