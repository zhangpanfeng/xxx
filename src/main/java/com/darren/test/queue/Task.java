package com.darren.test.queue;

import java.util.List;

public class Task implements Runnable {
    private List<Integer> taskIdList;
    private int modle;
    private BlockQueueTest blockQueueTest;
    private int threadCount;

    public Task(List<Integer> taskIdList, int modle, int threadCount, BlockQueueTest blockQueueTest) {
        this.taskIdList = taskIdList;
        this.modle = modle;
        this.blockQueueTest = blockQueueTest;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        int size = taskIdList.size();
        for (int i = 0; i < size; i++) {
            int tadkId = taskIdList.get(i);
            if (tadkId % threadCount == modle) {
                blockQueueTest.addCount();
                System.out.println("Task " + tadkId + " is working...... Current process: " + blockQueueTest.getCount()
                        + " / " + size);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        blockQueueTest.taskFinish(Thread.currentThread().getName());
    }

}
