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
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < lengthOfString; i++) {
            int signProbability = 1 + random.nextInt(100);
            String s = getRandomWord();
            if (i == 0) {
                strBuilder.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
            } else {
                strBuilder.append(getRandomWord());
            }
            if (signProbability > 50 && i < lengthOfString - 1) {
                strBuilder.append(", ");
            } else if (i < lengthOfString - 1) {
                strBuilder.append(' ');
            }
        }
        strBuilder.append(getRandomMark());
        return strBuilder.toString();
    }

    private char getRandomMark() {
        return MARKS[random.nextInt(MARKS.length)];
    }

    private String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
