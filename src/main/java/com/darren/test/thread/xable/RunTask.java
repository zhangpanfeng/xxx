package com.darren.test.thread.xable;

public class RunTask implements Runnable {

    private Calculator calculator;

    public RunTask(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        try {
            calculator.division(1, 0);
        } catch (Exception e) {
            System.out.println("run exception");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
