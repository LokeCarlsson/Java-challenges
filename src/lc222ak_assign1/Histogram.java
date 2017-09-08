package lc222ak_assign1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Histogram {
    public static void main(String URL) throws Error {
        try {
            File file = new File(URL);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text;
            int uppercase = 0;
            while((text=reader.readLine()) != null){
                for(int i = 0; i < text.length(); i++) {

                }
            }
            System.out.println("1 - 10 | " + uppercase);
            System.out.println("11 - 20 | " + uppercase);
            System.out.println("21 - 30 | " + uppercase);
            System.out.println("31 - 40 | " + uppercase);
            System.out.println("41 - 50 | " + uppercase);
            System.out.println("51 - 60 | " + uppercase);
            System.out.println("61 - 70 | " + uppercase);
            System.out.println("71 - 80 | " + uppercase);
            System.out.println("81 - 90 | " + uppercase);
            System.out.println("91 - 100 | " + uppercase);
            System.out.println("101 - 200 | " + uppercase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
