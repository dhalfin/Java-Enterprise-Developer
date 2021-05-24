package ru.itmentor.javacore.lessons.javaio;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextConstructor {
    private static final int MAX_SENTENCE_NUMBER = 20;
    private final StringConstructor stringConstructor;
    private final Random random;

    TextConstructor(String[] words) {
        this.stringConstructor = new StringConstructor(words);
        random = new Random();
    }

    //createNewText прежде, чем писать что-то в билдер, получает textLength предложений и сливает их в один список
    String createNewText() {
        StringBuilder sb = new StringBuilder();
        int textLength = 1 + random.nextInt(MAX_SENTENCE_NUMBER);
        int lineLength = 0;

        List<String> tokens = Stream
                .generate(stringConstructor::createSentence)
                .limit(textLength)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        sb.append('\t');
        for (int i = 0; i < tokens.size(); i++) {
            String word = (i == tokens.size() - 1) ? tokens.get(i) : (tokens.get(i) + " ");
            if (lineLength + word.length() > 100) {
                sb.append("\n");
                lineLength = 0;
            }
            sb.append(word);
            lineLength += word.length();
//            String word = tokens.get(i);
//            if (lineLength + (" " + word).length() > 100) {
//                if (i > 0) {
//                    sb.append("\n");
//                }
//                lineLength = 0;
//            }
//            lineLength += (tokens.get(i) + " ").length();
//            if (i < tokens.size() - 1) {
//                word += " ";
//            }
//            sb.append(word);
        }
        sb.append('\n');
        return sb.toString();
    }
}


