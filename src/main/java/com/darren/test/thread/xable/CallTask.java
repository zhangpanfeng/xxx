package com.darren.test.thread.xable;

import java.util.concurrent.Callable;

public class CallTask implements Callable<Integer> {

    private Calculator calculator;

    public CallTask(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Integer call() throws Exception {
        return calculator.division(1, 0);
    }

}
