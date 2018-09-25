package com.darren.test.java8;

import java.util.function.Supplier;

import org.junit.Test;

public class TestMethodRef {

    @Test
    public void test5() {
        Employee emp = new Employee("Darren", 10, 10);
        Supplier<Integer> sup = emp::getAge;

        System.out.println(sup.get());
    }
}
