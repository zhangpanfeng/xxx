package com.darren.test.thread;

public class SingleThreadTest {
    private static final int LOOP_TIMES = 10000;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for(int i = 0; i < LOOP_TIMES; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        long end = System.currentTimeMillis();
        System.out.println("Total : " + (end - start));
    }

}
