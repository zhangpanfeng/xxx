package com.darren.test.block;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Provider extends Thread {
    ArrayBlockingQueue<String> queue;

    public Provider(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            provider(i);
        }
    }

    public void provider(int index) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
            this.queue.put("" + index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "   provider");
    }
}
