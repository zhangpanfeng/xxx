package com.darren.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPollTest {
    private static final int LOOP_TIMES = 10000;
    private volatile int count;
    long start = System.currentTimeMillis();

    public static void main(String[] args) {
        ThreadPollTest test = new ThreadPollTest();
        ExecutorService pool = Executors.newFixedThreadPool(300);
//        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < LOOP_TIMES; i++) {
            Task t = new Task(test);
            pool.execute(t);
        }
        pool.shutdown();
    }

    public synchronized void nodify() {
        count++;
        if (count == LOOP_TIMES) {
            this.continueGo();
        }
    }

    public void continueGo() {
        long end = System.currentTimeMillis();
        System.out.println("Total : " + (end - start));
    }
}
