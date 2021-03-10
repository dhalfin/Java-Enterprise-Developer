package ru.itmentor.javacore.lessons.threads;

import java.math.BigDecimal;

public class FactorialCalc extends Thread {
    private final int number;
    private BigDecimal factorial;

    FactorialCalc(int number) { this.number = number; }

    @Override
    public void run() { factorial = calculateFactorial(number); }

    private static BigDecimal calculateFactorial(int number) {
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(new BigDecimal(i));
        }
        return factorial;
    }

    public BigDecimal getFactorial() { return factorial; }

    public int getNumber() { return number; }
}
