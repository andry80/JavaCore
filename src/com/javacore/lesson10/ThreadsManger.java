package com.javacore.lesson10;

import java.util.ArrayList;

public class ThreadsManger {
    public static void main(String[] args) throws InterruptedException {
        int countOperation = 1000;

        ThreadCounter counter = new ThreadCounter(countOperation);
        startTask(counter);

        ThreadAtomicIntegerCounter atomic = new ThreadAtomicIntegerCounter(countOperation);
        startTask(atomic);

    }

    public static void startTask(Runnable thread) throws InterruptedException {

        ArrayList<Thread> threadCounters = new ArrayList<>();

        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            Thread trd = new Thread(thread);

            threadCounters.add(trd);

            trd.start();
        }

        for (Thread trd1 : threadCounters) {
            trd1.join();
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println((timeEnd - timeStart) + " ms");

        System.out.println(thread);

    }
}
