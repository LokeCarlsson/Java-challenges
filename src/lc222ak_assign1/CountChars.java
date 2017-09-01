package lc222ak_assign1;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountChars {
    public static void main(String URL) throws Error {
        try {
            File file = new File(URL);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text;
            int uppercase = 0;
            int lowercase = 0;
            int numberChar = 0;
            int whitespace = 0;
            int otherChar = 0;
            while((text=reader.readLine()) != null){
                for(int i = 0; i < text.length(); i++) {
                    if (Character.isUpperCase(text.charAt(i))) {
                        uppercase++;
                    } else if (Character.isLowerCase(text.charAt(i))) {
                        lowercase++;
                    } else if (Character.isDigit(text.charAt(i))) {
                        numberChar++;
                    } else if (Character.isSpaceChar(text.charAt(i))) {
                        whitespace++;
                    } else {
                        otherChar++;
                    }
                }
            }
            System.out.println("Uppercase: " + uppercase);
            System.out.println("Lowercase: " + lowercase);
            System.out.println("Number: " + numberChar);
            System.out.println("Whitespace: " + whitespace);
            System.out.println("Other char: " + otherChar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
