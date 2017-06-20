package com.darren.test.thread.custom.future;


import com.darren.test.thread.xable.Calculator;
import com.darren.test.thread.xable.CallTask;

public class TaskTest {

    public static void main(String[] args) {
        SingleThreadExecutor service = new SingleThreadExecutor();
        Calculator calculator = new Calculator();
        CallTask task = new CallTask(calculator);
        CustomFuture<Integer> future = service.submit(task);
        // RunTask task = new RunTask(calculator);
        // Future<?> future = service.submit(task);

        // service.invokeAll(tasks)

        try {
            System.out.println("future.get() is a blocking method!");
            Integer result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("1");
            e.printStackTrace();
        }
    }

}
