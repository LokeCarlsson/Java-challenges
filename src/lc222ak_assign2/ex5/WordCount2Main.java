package lc222ak_assign2.ex5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class WordCount2Main {
    public void main() throws IOException {
        String URL = "/home/loke/Documents/school/2DV600/src/words.txt";
        File file = new File(URL);
        HashWordSet hashWordSet = new HashWordSet();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    hashWordSet.add(new Word(word));
                }
            }
        }
        System.out.println(hashWordSet.toString());
    }
}
