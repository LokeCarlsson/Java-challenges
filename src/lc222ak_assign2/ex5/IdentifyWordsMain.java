package lc222ak_assign2.ex5;

import java.io.*;

public class IdentifyWordsMain {
    public void main() throws IOException {
        String URL = "/home/loke/Documents/school/2DV600/src/HistoryOfProgramming.txt";
        String OutputURL = "/home/loke/Documents/school/2DV600/src/words.txt";
        File file = new File(URL);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() > 0) {
                String output = line.replaceAll("[^a-zA-Z]", " ").replaceAll(" +", " ").trim();
                text.append(output).append("\n");
            }
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(OutputURL), "utf-8"))) {
            writer.write(text.toString());
        }
    }
}