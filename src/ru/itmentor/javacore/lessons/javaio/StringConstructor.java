package ru.itmentor.javacore.lessons.javaio;

import java.util.Random;

public class StringConstructor {

    private final String[] words;
    private static final char[] MARKS = {'.', '!', '?'};
    private final int lengthOfString;
    private final Random random;

    public StringConstructor(String[] words) {
        this.words = words;
        random = new Random();
        lengthOfString = 1 + random.nextInt(15);
    }

    String createNewString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengthOfString; i++) {
            int signProbability = 1 + random.nextInt(100);
            String str = getRandomWord();
            if (i == 0) {
                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
            } else {
                sb.append(getRandomWord());
            }
            if (signProbability > 50 && i < lengthOfString - 1) {
                sb.append(", ");
            } else if (i < lengthOfString - 1) {
                sb.append(' ');
            }
        }
        sb.append(getRandomMark());
        return sb.toString();
//        String str = strBuilder.toString();
//        String[] arr = str.split(" ");
//        StringBuilder strArr = new StringBuilder();
//        for (String s : arr) {
//            strArr.append(s);
//            if (strArr.length() > 1000) {
//                strArr.append("\n");
//            }
//            strArr.append(s);
//        }
//        return strArr.toString();
    }

    private char getRandomMark() {
        return MARKS[random.nextInt(MARKS.length)];
    }

    private String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
