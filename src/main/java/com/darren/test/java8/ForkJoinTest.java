package com.darren.test.java8;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.junit.Test;

public class ForkJoinTest {

    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<BigInteger> task = new ForkJoinCalculate(BigInteger.valueOf(0), BigInteger.valueOf(100000000l));
        BigInteger sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗时: " + Duration.between(start, end).toMillis());// 307634
        ((ForkJoinCalculate)task).printThread();
    }

    @Test
    public void test2() {
        Instant startTime = Instant.now();
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger start = BigInteger.valueOf(0);
        BigInteger end = BigInteger.valueOf(10000000000l);
        BigInteger STEPVALUE = BigInteger.valueOf(1);
        sum = sum.add(start);
        for (;;) {
            start = start.add(STEPVALUE);
            sum = sum.add(start);
            if (start.compareTo(end) == 0) {
                break;
            }
        }

        System.out.println(sum);
        Instant endTime = Instant.now();

        System.out.println("耗时: " + Duration.between(startTime, endTime).toMillis());// 620192
    }
    
    @Test
    public void test3(){
        List<BigInteger> list = new ArrayList<BigInteger>();
        
//        Collection<BigInteger> coll = Collections.
//        System.out.println(list.size());
        
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
//        list.stream().
        
        
//        2147483647
//        10000000000l
    }
}
