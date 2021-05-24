package ru.itmentor.javacore.lessons.javaio;

import java.util.*;
import java.util.stream.Stream;

//StringConstructor возвращает List<String> - слова в предложении, со знаками препинания, без пробелов.
public class StringConstructor {
    private final String[] words;
    private static final char[] MARKS = {'.', '!', '?'};
    //private final int lengthOfString;
    private final int lengthOfArr;
    private final Random random;
    //private static final int MAX_LINE_LENGTH = 48;

    public StringConstructor(String[] words) {
        this.words = words;
        random = new Random();
        //lengthOfString = 1 + random.nextInt(15);
        lengthOfArr = 1 + random.nextInt(15);
    }

    List<String> createSentence() {
        List<String> words = new ArrayList<>();
        words.add(getFirstWord());
        Stream.generate(this::getMiddleWord)
                .limit(lengthOfArr - 2)
                .forEach(words::add);
        words.add(getLastWord());
        return words;
    }

    private String getFirstWord() {
        String word = getRandomWord();
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private String getMiddleWord() {
        return Math.random() > 0.95 ? (getRandomWord() + ",") : getRandomWord();
    }

    private String getLastWord() {
        return getRandomWord() + getRandomMark();
    }

    private char getRandomMark() {
        return MARKS[random.nextInt(MARKS.length)];
    }

    private String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}

//    List<String> createNewString() {
//        List<String> words = new ArrayList<>();
//        String first = getRandomWord();
//        first = first.substring(0, 1).toUpperCase() + first.substring(1);
//        words.add(first);
//        for (int i = 0; i < lengthOfArr - 2; i++) {
//            String word = getRandomWord();
//            words.add(word);
//        }
//        String randomWord = words.get(random.nextInt(words.size() - 1));
//        int index = words.indexOf(randomWord);
//        randomWord += ",";
//        words.set(index, randomWord);
//        String last = getRandomWord() + getRandomMark();
//        words.add(last);
//        return words;
//    }

//    List<String> createNewString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < lengthOfString; i++) {
//            int signProbability = 1 + random.nextInt(100);
//            String str = getRandomWord();
//            if (i == 0) {
//                sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1));
//            } else {
//                sb.append(getRandomWord());
//            }
//            if (signProbability > 95 && i < lengthOfString - 1) {
//                sb.append(", ");
//            } else if (i < lengthOfString - 1) {
//                sb.append(' ');
//            }
//        }
//        sb.append(getRandomMark());
//        return new ArrayList<>(Arrays.asList(sb.toString().split("\\s+")));
//    }

//    public static String moveToNextLine(String input, int maxLineLength) {
//        String[] tokens = input.split("\\s+");
//        StringBuilder output = new StringBuilder(input.length());
//        int lineLength = 0;
//        for (int i = 0; i < tokens.length; i++) {
//            String word = tokens[i];
//            if (lineLength + (" " + word).length() > maxLineLength) {
//                if (i > 0) {
//                    output.append('\n');
//                }
//                lineLength = 0;
//            }
//            if (i < tokens.length - 1 &&
//                    (lineLength + (word + " ").length() + tokens[i + 1].length() <= maxLineLength)) {
//                word += " ";
//            }
//            output.append(word);
//            lineLength += word.length();
//        }
//        return output.toString();
//    }


