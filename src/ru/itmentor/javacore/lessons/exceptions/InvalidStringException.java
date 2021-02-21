package ru.itmentor.javacore.lessons.exceptions;

public class InvalidStringException extends Exception {
    private String string;

    InvalidStringException(String str) {

        this.string = str;
    }

    public String toString() {
        return "String: " + string + " is not a valid string";
    }
}

class Main {
    public static void main(String[] args) throws InvalidStringException {

        checkString("Hello, ...!");
    }

    static void checkString(String s) throws InvalidStringException {
        //System.out.println("Checking String validity : (" + s + ")");
        if (s != "Hello, World!") {
            throw new InvalidStringException(s);
        }
        System.out.println(s);
    }
}
