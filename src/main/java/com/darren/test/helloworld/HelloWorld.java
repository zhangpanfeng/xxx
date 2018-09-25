package com.darren.test.helloworld;

public class HelloWorld {

    public static void main(String[] args) {
        int m = 5;
        int a = 10;
        a = a++;
        System.out.println(a);
        System.out.println(m);
        a++;
        System.out.println(a);
        
        
        int b = 10;
        b = ++b;
        System.out.println(b);
        
        int c = 10;
        c++;
        System.out.println(c);
        
        float d = 10;
        d++;
        System.out.println(d);
        
        d = m;
    }

}
