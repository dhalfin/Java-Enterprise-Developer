package ru.itmentor.javacore.lessons.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialThread implements Callable {
    private final int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public Integer[] call() throws Exception {
        System.out.println("Number: " + number);
        int result = 1;
        try {
            for (int i = number; i > 0; i--) {
                TimeUnit.SECONDS.sleep(1);
                result *= i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Integer[]{number, result};
    }
}
