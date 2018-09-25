package com.darren.test.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class TestJUC {

    @Test
    public void test(){
        int i = 1;
        i = i++;
        System.out.println(i);
        
       // CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//            list.add("MM");
//            
//        }
        
        for (String string : list) {
            System.out.println(string);
            
            list.add("MM");
        }
    }
}
