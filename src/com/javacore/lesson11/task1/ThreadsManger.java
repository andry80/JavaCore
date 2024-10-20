package com.javacore.lesson11.task1;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsManger {
    public static void main(String[] args) throws InterruptedException {
        int countOperation = 10000000;

        ThreadCounter counter = new ThreadCounter(countOperation);
        startTask(counter);

        ThreadAtomicIntegerCounter atomic = new ThreadAtomicIntegerCounter(countOperation);
        startTask(atomic);

    }

    public static void startTask(Runnable thread) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            executorService.submit(thread);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        long timeEnd = System.currentTimeMillis();


        System.out.println((timeEnd - timeStart) + " ms");

        System.out.println(thread);

    }
}