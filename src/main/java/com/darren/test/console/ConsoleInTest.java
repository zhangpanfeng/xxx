package com.darren.test.console;

import java.util.Scanner;

public class ConsoleInTest {
private  static volatile boolean CONDITION = true;
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            
            
            @Override
            public void run() {
                while(CONDITION){
                    System.out.println("Darren");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Scanner in = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = in.nextLine();
        System.out.println("Hello "+name+".");
        CONDITION = false;
    }

}
