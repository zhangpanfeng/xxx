package com.darren.test.java8;

import java.util.Optional;

import org.junit.Test;

public class OptionalTest {

    @Test
    public void test1(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
        
//        op.orElse(other)
    }
}
