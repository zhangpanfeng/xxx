package com.darren.test.thread.xable;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new RunTask(new Calculator()));
        thread.start();
    }
}
