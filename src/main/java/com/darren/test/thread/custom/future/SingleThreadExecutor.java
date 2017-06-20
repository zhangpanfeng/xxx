package com.darren.test.thread.custom.future;

import java.util.concurrent.Callable;

public class SingleThreadExecutor {

    public SingleThreadExecutor() {

    }

    public <T> CustomFuture<T> submit(Callable<T> callable) {
        return new CustomFuture<T>(callable);
    }
}
