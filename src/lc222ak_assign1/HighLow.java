package lc222ak_assign1;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) throws Error {
        System.out.println("Pick a number!");

        int counter = 0;
        boolean done = false;

        Random rng = new Random();
        int randomInteger = rng.nextInt(100);

        do {
            Scanner inputText = new Scanner(System.in);
            String text = inputText.nextLine();
            int inputNumber = Integer.parseInt(text);
            if (inputNumber > randomInteger) {
                System.out.println("Lower!");
                counter++;
            } else if ( inputNumber < randomInteger) {
                System.out.println("Higher");
                counter++;
            } else {
                System.out.println("You won after " + counter + " guesses! Awesome!");
                done = true;
            }
        } while (!done);
    }
}
