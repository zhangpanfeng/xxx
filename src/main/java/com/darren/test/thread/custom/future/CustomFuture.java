package com.darren.test.thread.custom.future;

import java.util.concurrent.Callable;

public class CustomFuture<T> implements Runnable {
    private Callable<T> callable;
    private T value;
    private volatile boolean flag;
    private volatile Exception e;

    public CustomFuture(Callable<T> callable) {
        this.callable = callable;
        Thread thread = new Thread(this);
        thread.start();
    }

    public T get() throws Exception {
        while (!flag) {
            try {
                System.out.println("任务没有完成，等待。。。");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.e != null) {
            throw e;
        }
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public void run() {
        try {
            T value = callable.call();
            this.set(value);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = e;
        } finally {
            this.flag = true;
        }
    }
}
