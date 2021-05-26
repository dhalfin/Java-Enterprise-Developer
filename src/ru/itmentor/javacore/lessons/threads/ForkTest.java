package ru.itmentor.javacore.lessons.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkTest {
    public static void main(String[] args) {
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
        ForkJoinPool forkJoinPool = new ForkJoinPool(cores);

        for (int number : array) {
            Factorial myRecursiveAction = new Factorial(2, number);
            forkJoinPool.invoke(myRecursiveAction);
            System.out.println("i = " + number + " result = " + myRecursiveAction.getRawResult());
        }
    }
}

class Factorial extends RecursiveTask<Long> {
    private final int low;
    private final int high;

    public Factorial(int low, int high) {
        this.low = low;
        this.high = high;
    }

    protected Long compute() {
        if (high - low >= 2) {
            int mid = (high + low) / 2;
            Factorial lowerRange = new Factorial(low, mid);
            Factorial higherRange = new Factorial(mid + 1, high);
            List<Factorial> subtasks = new ArrayList<Factorial>();
            subtasks.add(lowerRange);
            subtasks.add(higherRange);

            for (Factorial subtask : subtasks) {
                subtask.fork();
            }

            long result = 1;
            for (Factorial subtask : subtasks) {
                result *= subtask.join();
            }
            return result;
        } else {
            long facto = low;
            for (int i = low + 1; i <= high; i++) {
                facto = facto * i;
            }
            return facto;
        }
    }
}
