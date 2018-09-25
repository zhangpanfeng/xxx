package com.darren.test.java8;

import java.math.BigInteger;
import java.util.Vector;
import java.util.concurrent.RecursiveTask;


public class ForkJoinCalculate extends RecursiveTask<BigInteger> {
    /**
     * 
     */
    private static final long serialVersionUID = 8703875286325008201L;

    private BigInteger start;
    private BigInteger end;
    private static final BigInteger THRESHOLD = BigInteger.valueOf(1000000);
    private static final BigInteger DIVIDEVALUE = BigInteger.valueOf(2);
    private static final BigInteger STEPVALUE = BigInteger.valueOf(1);
    private Vector<String> threads = new Vector<>();

    public ForkJoinCalculate(BigInteger start, BigInteger end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigInteger compute() {
        String threadName = Thread.currentThread().getName();
        synchronized(this){
            if(!threads.contains(threadName)){
                threads.add(threadName);
                System.out.println(threadName);
            }
        }
        if ((end.subtract(start)).compareTo(THRESHOLD) != 1) {
            BigInteger sum = BigInteger.valueOf(0);
            sum = sum.add(start);
            for (;;) {
                start = start.add(STEPVALUE);
                sum = sum.add(start);
                if (start.compareTo(end) == 0) {
                    break;
                }
            }

            return sum;
        } else {
            BigInteger middle = (start.add(end)).divide(DIVIDEVALUE);
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            // 拆分，并将该子任务压入线程队列
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle.add(STEPVALUE), end);
            right.fork();

            return left.join().add(right.join());
        }
    }
    
    public void printThread(){
        for (String string : threads) {
            System.out.println(string);
        }
    }
}
