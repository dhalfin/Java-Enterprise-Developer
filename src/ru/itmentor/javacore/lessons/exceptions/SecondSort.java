package ru.itmentor.javacore.lessons.exceptions;

import java.util.*;

public class SecondSort implements SortInterface {

    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        n = in.nextInt();

        if (n < 10000) {
            System.out.println("Array must be 10000 or bigger, try again..");
            n = in.nextInt();
        } else {

            List<List<Person>> listOfPersons = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                listOfPersons.add(new ArrayList<>());
            }
        }
    }

    @Override
    public void sort() {

    }
}
