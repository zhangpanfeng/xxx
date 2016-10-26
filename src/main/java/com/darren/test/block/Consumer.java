package com.darren.test.block;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread {
    ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            consumer();
        }
    }

    public void consumer() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
            String value = this.queue.take();
            System.out.println("value = " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
