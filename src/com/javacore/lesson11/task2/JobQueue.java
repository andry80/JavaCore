package com.javacore.lesson11.task2;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class JobQueue {
    Queue<Runnable> jobs = new LinkedList<>();
    final Object lock = new Object();

    public synchronized void put(Runnable job) throws InterruptedException {
        synchronized (lock) {
            jobs.add(job);
            lock.notify();
        }
    }

    public Runnable getJob() throws InterruptedException {
        synchronized (lock) {
            while (jobs.size() == 0) {
                lock.wait();
            }
            return jobs.poll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JobQueue jobQueue = new JobQueue();

        Thread threadPut = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    Task task = new Task();
                    try {
                        jobQueue.put(task);
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread threadGet = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        jobQueue.getJob().run();

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        threadPut.start();
        threadGet.start();

    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());
    }
}