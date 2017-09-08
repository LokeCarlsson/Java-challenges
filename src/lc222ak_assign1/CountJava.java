package lc222ak_assign1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CountJava {
    public static void main(String URL) throws Error {
        try (Stream<Path> paths = Files.walk(Paths.get(URL))) {
            paths
            .filter(Files::isRegularFile)
            .forEach((string) -> {
                try {
                    findLines(String.valueOf(string));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFileExtension(String URL) {
        String extension = "";
        try {
            int i = URL.lastIndexOf('.');
            if (i >= 0) {
                return URL.substring(i+1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return extension;
    }

    private static void findLines(String URL) throws FileNotFoundException {
        String fileType = getFileExtension(URL);
        int lineCount = readLines(URL);
        if (Objects.equals(fileType, "java")) {
            int i = URL.lastIndexOf('/');
            if (i >= 0) {
                System.out.println(URL.substring(i+1) + "  Lines = " + lineCount);
            }

        }
    }

    private static int readLines(String URL) throws FileNotFoundException {
        int lineCount = 0;
        try {
            File file = new File(URL);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Pattern p = Pattern.compile("-?\\d+");
            while((reader.readLine()) != null){
                lineCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
