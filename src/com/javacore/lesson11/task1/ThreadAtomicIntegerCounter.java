package com.javacore.lesson11.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicIntegerCounter implements Runnable {

    public static AtomicInteger counter = new AtomicInteger();

    public static void increment() {
        counter.incrementAndGet();
    }

    private int countOperantion;

    public ThreadAtomicIntegerCounter(int countOperantion) {
        this.countOperantion = countOperantion;
    }

    @Override
    public void run() {
        for (int i = 0; i < countOperantion; i++) {
            increment();
        }
    }

    @Override
    public String toString() {
        return "result: " + counter.toString();
    }
}
