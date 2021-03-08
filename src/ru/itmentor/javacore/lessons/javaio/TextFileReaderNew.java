package ru.itmentor.javacore.lessons.javaio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileReaderNew {
    public static void main(String[] args) throws IOException {

        try (PrintWriter writer = new PrintWriter("src/ru/itmentor/javacore/lessons/javaio/resources/target.txt")) {
            Files.readAllLines(Paths.get("src/ru/itmentor/javacore/lessons/javaio/resources/source.txt"))
                    .stream()
                    .map(line -> line.replaceAll("\\p{P}", ""))
                    .map(String::toLowerCase)
                    .map(s -> s.split("\\s+"))//сплит возвращает массив, т.е. мапишь строчку в массив строчек
                    .flatMap(Arrays::stream)//стрим из массивов строк превратить просто в стрим строк
                    .distinct()
                    .sorted()
                    .forEach(writer::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        List<String> lines = Files.readAllLines(Paths.get("src/ru/itmentor/javacore/lessons/javaio/resources/source.txt"));
//        List<String> words = lines.stream()
//                .map(line -> line.replaceAll("\\p{P}", ""))
//                .map(String::toLowerCase)
//                .map(s -> s.split("\\s+"))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//
//        try (PrintWriter pw = new PrintWriter(new FileOutputStream("src/ru/itmentor/javacore/lessons/javaio/resources/target.txt", true))) {
//            for (String s : words) {
//                pw.println(s);
//            }
//        }
    }

//        try (FileWriter fileWriter = new FileWriter("src/ru/itmentor/javacore/lessons/javaio/resources/target.txt", true)) {
//            for (String s : words) {
//                fileWriter.write(s + "\n");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

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



