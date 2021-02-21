package ru.itmentor.javacore.lessons.exceptions;

import java.util.*;

public class RandomNumber {
    public static void main(String[] args) throws InvalidValueException {
        int n, arr[];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        n = in.nextInt();
        in.close();
        arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * n);
            if (arr[i] < 0) {
                throw new InvalidValueException(arr);
            }
        }

        for (int k : arr) {
            double q = Math.sqrt(k);
            int intPart = (int) q;
            if (Math.pow(intPart, 2) == k) {
                System.out.print(k + " ");
            }
        }
    }
}

class InvalidValueException extends Exception {

    private int[] array;

    public InvalidValueException(int[] array) {
        this.array = array;
    }

    public String toString() {
        return "ARRAY: " + array + " is not a valid array";
    }
}


//    public static List<Integer> generateRandomArray(int n) {
//        ArrayList<Integer> list = new ArrayList<Integer>(n);
//        int min = -115;
//        int max = 100;
//        int diff = max - min;
//        Random random = new Random();
//
//        for (int i = 0; i < n; i++) {
//            list.add(random.nextInt(diff + 1) + min);
//        }
//        return list;
//    }

