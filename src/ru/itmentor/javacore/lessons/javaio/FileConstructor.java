package ru.itmentor.javacore.lessons.javaio;

import java.io.*;

public class FileConstructor {
    private static final String TARGET = "src/ru/itmentor/javacore/lessons/javaio/resources/hw2/";
    private static final int KILOBYTE = 1024;
    private static final String[] wordsArray = {"really ", "love", "will save", "this",
            "world", "he", "she", "loves", "combination", "sea", "one", "goes" , "forever", "vacation", "have",
            "programmer", "on", "the", "a", "rest", "is", "matter", "takes", "place", "coding"};

    public static void main(String[] args) {

        getFiles(TARGET, 1, 500, wordsArray);
    }

    public static void getFiles(String path, int n, int size, String[] words) {
        TextConstructor tc = new TextConstructor(words);
        if (size > 0) {
            for (int i = 0; i < n; i++) {
                String filePath = path + "/file_" + i + ".txt";
                File file = new File(filePath);

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    int sizeInKiloByte = size * KILOBYTE;
                    while (sizeInKiloByte > 0) {
                        String str = tc.createNewText();
                        if (sizeInKiloByte > str.length()) {
                            bw.write(str);
                            sizeInKiloByte -= str.length();
                        } else break;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Путь к файлу неверный " + e);
                } catch (IOException e) {
                    System.out.println("Невозможно записать в файл " + e);
                }
            }
        }
    }
}
