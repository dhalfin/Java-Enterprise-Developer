package ru.itmentor.javacore.lessons.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        final Integer[] array = new Integer[size];
        System.out.println("Insert array elements:");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available CPU cores: " + cores);
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        List<Future> futureList = new ArrayList<>();

        for (int number : array) {
            Future future = executorService.submit(new FactorialThread(number));
            futureList.add(future);
        }

        for (Future future : futureList) {
            Integer[] results = (Integer[]) future.get();
            System.out.println("Digit: " + results[0] + " - Result: " + results[1]);
        }
    }
}
