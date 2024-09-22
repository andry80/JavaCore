package com.javacore.lesson10;

public class ThreadCounter implements Runnable {

    public static int counter;

    public static /*synchronized*/ void nextCount() {
        counter++;
    }

    private int countOperantion;

    public ThreadCounter(int countOperantion) {
        this.countOperantion = countOperantion;
    }

    @Override
    public void run() {
        for (int i = 0; i < countOperantion; i++) {
            nextCount();
        }
    }

    @Override
    public String toString() {
        return "result: " + counter;
    }
}
