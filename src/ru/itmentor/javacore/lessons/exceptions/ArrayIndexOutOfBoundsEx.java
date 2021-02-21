package ru.itmentor.javacore.lessons.exceptions;

public class ArrayIndexOutOfBoundsEx {
    public static void main(String[] args) {

        int intArray[] = new int[3];

        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;

        for (int i = 0; i < 4; i++) {
            System.out.println(intArray[i] + " Hello, World!");
        }
    }
}
