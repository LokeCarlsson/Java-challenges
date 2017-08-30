package lc222ak_assign1;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) throws Error {
        Scanner inputText = new Scanner(System.in);
        String text = inputText.nextLine();
        String[] stringArr = text.split("");
        int inputNumber = Integer.parseInt(text);
        int zeros = 0;
        int odds = 0;
        int evens = 0;
        int sum = 0;
        int length = Integer.toString(inputNumber).length();

        for(int i = 0; i < length; i++) {

            if (Integer.parseInt(stringArr[i]) == 0) {
                zeros++;
            }
            else if (Integer.parseInt(stringArr[i]) % 2 == 0) {
                evens++;
            }
            else {
                odds++;
            }
            sum += Integer.parseInt(stringArr[i]);
        }

        System.out.println("Zeros: " + zeros);
        System.out.println("Odds: " + odds);
        System.out.println("Evens: " + evens);
        System.out.println("Sum: " + sum);
    }
}
