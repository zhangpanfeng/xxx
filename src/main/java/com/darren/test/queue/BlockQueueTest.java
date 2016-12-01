package com.darren.test.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueTest {
    private static final int THREAD_COUNT = 3;
    private static final ArrayBlockingQueue<Integer> QUEUE = new ArrayBlockingQueue<Integer>(1);
    private volatile int currentCount;
    private volatile int executeCount;

    public static void main(String[] args) {
        BlockQueueTest blockQueueTest = new BlockQueueTest();

        List<Integer> taskIdList = new ArrayList<Integer>();
        for (int i = 0; i < 200; i++) {
            taskIdList.add(1000 + i);
        }

        Task task1 = new Task(taskIdList, 0, THREAD_COUNT, blockQueueTest);
        Task task2 = new Task(taskIdList, 1, THREAD_COUNT, blockQueueTest);
        Task task3 = new Task(taskIdList, 2, THREAD_COUNT, blockQueueTest);
        new Thread(task1, "task1").start();
        new Thread(task2, "task2").start();
        new Thread(task3, "task3").start();

        int result = 0;
        try {
            result = QUEUE.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result = " + result);

    }

    public synchronized void addCount() {
        executeCount++;
    }

    public int getCount() {
        return executeCount;
    }

    public synchronized void taskFinish(String threadName) {
        currentCount++;
        System.out.println("Thread " + threadName + "finished");
        if (currentCount == THREAD_COUNT) {
            try {
                QUEUE.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
