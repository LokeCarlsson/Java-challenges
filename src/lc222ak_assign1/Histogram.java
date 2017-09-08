package lc222ak_assign1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Histogram {
    public static void main(String URL) throws Error {
        try {
            File file = new File(URL);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String text;
            int[] result = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            Pattern p = Pattern.compile("-?\\d+");
            while((text=reader.readLine()) != null){
                Matcher m = p.matcher(text);
                while(m.find()) {
                    int textInt = Integer.parseInt(m.group());
                    if (textInt >= 1 && textInt <= 10) {
                        result[0]++;
                    } else if (textInt < 20) {
                        result[1]++;
                    } else if (textInt < 30) {
                        result[2]++;
                    } else if (textInt < 40) {
                        result[3]++;
                    } else if (textInt < 50) {
                        result[4]++;
                    } else if (textInt < 60) {
                        result[5]++;
                    } else if (textInt < 70) {
                        result[6]++;
                    } else if (textInt < 80) {
                        result[7]++;
                    } else if (textInt < 90) {
                        result[8]++;
                    } else if (textInt < 100) {
                        result[9]++;
                    } else if (textInt < 200) {
                        result[10]++;
                    }
                }
            }
            print("1 - 10    | ", result[0]);
            print("11 - 20   | ", result[1]);
            print("21 - 30   | ", result[2]);
            print("31 - 40   | ", result[3]);
            print("41 - 50   | ", result[4]);
            print("51 - 60   | ", result[5]);
            print("61 - 70   | ", result[6]);
            print("71 - 80   | ", result[7]);
            print("81 - 90   | ", result[8]);
            print("91 - 100  | ", result[9]);
            print("101 - 200 | ", result[10]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print(String range, int number) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stars.append("*");
        }
        System.out.println(range + stars);
    }
}
