package com.darren.test.thread;

public class Task implements Runnable {
    private ThreadPollTest test;

    public Task(ThreadPollTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
//        System.out.println(Thread.currentThread().getName());
        test.nodify();
    }

}
