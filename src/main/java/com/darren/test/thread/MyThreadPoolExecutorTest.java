package com.darren.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Test;

public class MyThreadPoolExecutorTest {
    static Runnable task = new Runnable() {

        @Override
        public void run() {
            int a = 1/0;
        }
    };
    
    static ExecutorService service = new MyThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
    
    
    public static void main(String[] args) {

        service.submit(task);
        
        //service.execute(task);
        
        
        service.shutdown();
        // Executors.newFixedThreadPool(1).execute(task);
    }

    @Test
    public void testExecute() {
        service.execute(task);
    }

    @Test
    public void testSubmit() {
        service.submit(task);
    }
    
    @AfterClass
    public void afterClass(){
        service.shutdown();
    }
}
