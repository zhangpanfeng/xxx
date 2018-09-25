package com.darren.test.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DateTimeTest {

    @Test
    public void test(){
        LocalDate ld = LocalDate.now();
        
        System.out.println(ld);
    }
    
    @Test
    public void test2(){
        LocalTime lt = LocalTime.now();
        
        System.out.println(lt);
    }
    
    @Test
    public void test3(){
        LocalDateTime ldt = LocalDateTime.now();
        
        System.out.println(ldt);
    }
    
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        
        String dateTime = ldt.format(dtf);
        System.out.println(dateTime);
        
        LocalDateTime ldt2 = LocalDateTime.parse("2017-07-07T10:10:10", dtf);
        System.out.println(ldt2);
        
        Duration duration = Duration.between(ldt2, ldt);
        System.out.println(duration);
        
        System.out.println(duration.getSeconds());
        System.out.println(duration.getSeconds()/60);
        
        LocalDate ld = ldt.toLocalDate();
        LocalDate ld2 = ldt2.toLocalDate();
        Period perion = Period.between(ld2, ld);
        System.out.println(perion);
    }
    
    @Test
    public void test5(){
        LocalDateTime ldt = LocalDateTime.now();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        
        String dateTime = ldt.format(dtf);
        System.out.println(dateTime);
    }
}
