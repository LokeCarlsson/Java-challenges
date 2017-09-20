package lc222ak_assign1;

import java.util.Scanner;

public class LargestK {
    public static void main() throws Error {
        Scanner inputText = new Scanner(System.in);
        int inputNumber = Integer.parseInt(inputText.nextLine());
        int highestNumber = 0;
        for(int i = 0; i <= inputNumber; i++) {
            if (i % 2 == 0) {
                highestNumber = i;
            }
        }

        System.out.print(highestNumber);
    }
}
