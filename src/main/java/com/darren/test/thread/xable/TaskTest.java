package com.darren.test.thread.xable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Calculator calculator = new Calculator();
        CallTask task = new CallTask(calculator);
        Future<Integer> future = service.submit(task);
        //RunTask task = new RunTask(calculator);
        //Future<?> future = service.submit(task);
        
        
//        service.invokeAll(tasks)
        
        try {
            System.out.println("future.get() is a blocking method!");
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            System.out.println("1");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("2");
            e.printStackTrace();
        }
        
        service.shutdown();
    }

}
