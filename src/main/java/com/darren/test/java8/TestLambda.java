package com.darren.test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Supplier;

import org.junit.Test;

public class TestLambda {

    // 原来匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                // TODO Auto-generated method stub
                return Integer.compare(x, y);
            }
        };

        TreeSet<Integer> tree = new TreeSet<>(com);
    }

    // Lambda 表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> tree = new TreeSet<>(com);
    }
    
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test3(){
        List<Employee> list = filterEmployee(employees, (e)->e.getSalary() >=5000);
        list.forEach(System.out::println);
    }
    
    @Test
    public void test4(){
        employees.stream().filter((e)->e.getSalary() >=5000).forEach(System.out::println);
        
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
    
    public List<Employee> filterEmployee(List<Employee> employees, Filter<Employee> filter) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.filter(employee)) {
                list.add(employee);
            }
        }

        return list;
    }
}
