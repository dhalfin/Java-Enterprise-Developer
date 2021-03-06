package ru.itmentor.javacore.lessons.javaio;

import java.io.*;

public class FileConstructor {

    private static final int KILOBYTE = 1024;

    public void getFiles(String path, int n, int size, String[] words) {
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
