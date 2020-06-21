package com.lesnoytishka;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock locker = new ReentrantLock();
    private int counter = 0;
    private final Thread[] threads = new Thread[5];

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.startThreads();
    }

    public void startThreads() {
        initThreads();
        for (Thread thr : threads) {
            thr.start();
        }
    }

    private void initThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    increaseCounter("T" + (j + 1));
                }
            });
        }
    }

    private void increaseCounter(String threadName) {
        try {
            locker.lock();
            System.out.println(String.format("Thread [%s] increase counter to %s", threadName, ++counter));
            Thread.sleep(330);
        } catch (InterruptedException e) {
            System.err.println("----------------- error -----------------");
            e.printStackTrace();
            System.err.println("----------------- error -----------------");
        } finally {
            System.out.println(String.format("Thread [%s] ready to UNlock counter\n", threadName));
            locker.unlock();
        }
    }


}
