package ru.itmentor.javacore.lessons.exceptions;

public class NPE {

    public static void main(String[] args) {

        print(null);
    }

    public static void print(String str) {
        System.out.println(str.toLowerCase());
    }
}
