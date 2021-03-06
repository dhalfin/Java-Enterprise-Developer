package ru.itmentor.javacore.lessons.javaio;

import java.util.Random;

public class TextConstructor {

    private static final int MAX_SENTENCE_NUMBER = 20;
    private final StringConstructor stringConstructor;
    private final Random random;

    TextConstructor(String[] words) {
        this.stringConstructor = new StringConstructor(words);
        random = new Random();
    }

    String createNewText() {
        StringBuilder sb = new StringBuilder();
        int textLength = 1 + random.nextInt(MAX_SENTENCE_NUMBER);

        for (int i = 0; i < textLength; i++) {
            if (i == 0) {
                sb.append('\t');
            }
            sb.append(stringConstructor.createNewString());
            if (i < textLength - 1) {
                sb.append(' ');
            }
        }
        sb.append('\n');
        return sb.toString();
    }
}
