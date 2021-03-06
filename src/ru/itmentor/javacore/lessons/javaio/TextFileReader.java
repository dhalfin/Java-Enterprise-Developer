package ru.itmentor.javacore.lessons.javaio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class TextFileReader {

    private static final Set<String> wordsSet = new TreeSet<>();

    public static void main(String[] args) {
        String source = "src/ru/itmentor/javacore/lessons/javaio/resources/source.txt";
        String target = "src/ru/itmentor/javacore/lessons/javaio/resources/target.txt";

        fromFileToList(source);
        fromListToFile(target);
    }

    public static void fromFileToList(String fileResource) {
        try (FileInputStream fileInputStream = new FileInputStream(fileResource)) {
            int i = -1;
            boolean repeat = false;
            StringBuilder stringBuilder = new StringBuilder();
            while ((i = fileInputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }
            String[] resultWords = stringBuilder.toString().toLowerCase().split(" ");

            for (String resultWord : resultWords) {
                if (!wordsSet.add(resultWord)) {
                    repeat = true;
                }
            }
            if (repeat) {
                System.out.println("There were duplicate words in the original file!");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fromListToFile(String fileTarget) {
        try (FileWriter fileWriter = new FileWriter(fileTarget, true)) {
            for (String s : wordsSet) {
                fileWriter.write(s + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
