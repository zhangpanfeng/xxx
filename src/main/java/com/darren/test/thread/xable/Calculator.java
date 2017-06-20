package com.darren.test.thread.xable;

public class Calculator {

    public int add(int a, int b) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Sleeping finished!");
        return a + b;
    }

    public int division(int a, int b) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Sleeping finished!");
        return a / b;
    }
}
