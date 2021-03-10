package ru.itmentor.javacore.lessons.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        final Integer[] array = new Integer[size];
        System.out.println("Insert array elements:");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }

        new Thread(() -> {
            List<FactorialCalc> threads = new ArrayList<>();
            for (Integer integer : array) {
                FactorialCalc fc = new FactorialCalc(integer);
                threads.add(fc);
                fc.start();
            }
            for (FactorialCalc fc : threads) {
                try {
                    fc.join();
                    System.out.println(fc.getNumber() + "! = " + fc.getFactorial());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
