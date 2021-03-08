package ru.itmentor.javacore.lessons.javaio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileReaderNew {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("src/ru/itmentor/javacore/lessons/javaio/resources/source.txt"));
        List<String> words = lines.stream()
                .sorted()
                .distinct()
                .map(line -> line.replaceAll("\\p{P}", ""))
                .map(String::toLowerCase)
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        try (FileWriter fileWriter = new FileWriter("src/ru/itmentor/javacore/lessons/javaio/resources/target.txt", true)) {
            for (String s : words) {
                fileWriter.write(s + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        try (PrintWriter pW = new PrintWriter("src/ru/itmentor/javacore/lessons/javaio/resources/target.txt")) {
//            for (String s : words) {
//                pW.write(s + "\n");
//                pW.flush();
//                pW.close();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }


}
