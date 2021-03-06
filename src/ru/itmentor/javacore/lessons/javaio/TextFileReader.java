package ru.itmentor.javacore.lessons.javaio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class TextFileReader {

    private static final String SOURCE = "src/ru/itmentor/javacore/lessons/javaio/resources/source.txt";
    private static final String TARGET = "src/ru/itmentor/javacore/lessons/javaio/resources/target.txt";

    private static final Set<Character> CHARS_TO_FILTER;
    private static final Set<String> words;
    private static final StringBuilder sb;

    static {
        CHARS_TO_FILTER = new HashSet<>(Arrays.asList('.', ',', '?', '!', ':', ';', '*', '"', '-', '“', '”'));
        words = new TreeSet<>();
        sb = new StringBuilder();
    }

    public static void main(String[] args) {
        getFillingFromSource();
        convertStringToCollection();
        writeCollectionToTargetFile();
    }

    private static void getFillingFromSource() {
        try (FileInputStream fInStr = new FileInputStream(SOURCE)) {
            int i;
            while ((i = fInStr.read()) != -1) {
                char ch = (char) i;
                if (!CHARS_TO_FILTER.contains(ch)) {
                    sb.append(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertStringToCollection() {
        String filling = sb.toString().toLowerCase();
        words.addAll(Arrays.asList(filling.replace("\n", " ").split(" ")));
        words.remove("");
    }

    private static void writeCollectionToTargetFile() {
        try (FileOutputStream fOutStr = new FileOutputStream(TARGET)) {
            for (String str : words) {
                fOutStr.write(str.getBytes());
                fOutStr.write('\n');
                fOutStr.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
