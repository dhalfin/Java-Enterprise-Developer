package ru.itmentor.javacore.lessons.javaio;

import java.util.Random;

public class StringConstructor {
    private final String[] words;
    private static final char[] MARKS = {'.', '!', '?'};
    private final int lengthOfString;
    private final Random random;
    private static final int MAX_LINE_LENGTH = 48;

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
            if (signProbability > 95 && i < lengthOfString - 1) {
                sb.append(", ");
            } else if (i < lengthOfString - 1) {
                sb.append(' ');
            }
        }
        sb.append(getRandomMark());
        return moveToNextLine(sb.toString(), MAX_LINE_LENGTH);
    }

    public static String moveToNextLine(String input, int maxLineLength) {
        String[] tokens = input.split("\\s+");
        StringBuilder output = new StringBuilder(input.length());
        int lineLength = 0;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            if (lineLength + (" " + word).length() > maxLineLength) {
                if (i > 0) {
                    output.append('\n');
                }
                lineLength = 0;
            }
            if (i < tokens.length - 1 &&
                    (lineLength + (word + " ").length() + tokens[i + 1].length() <= maxLineLength)) {
                word += " ";
            }
            output.append(word);
            lineLength += word.length();
        }
        return output.toString();
    }

    private char getRandomMark() {
        return MARKS[random.nextInt(MARKS.length)];
    }

    private String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}
