package com.darren.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    private static int a = 0;
    private static final Map<String, String> MAP = new HashMap<String, String>();

    public void add() {
        a++;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
//        new Test1().add();
//        new Test1().add();
//        System.out.println(new Test1().getA());
//        MAP.put("a", "a");
//        Test2 t2 = new Test2();
//        t2.setMap(MAP);
////        MAP.clear();
//       for(String key: t2.getMap().keySet()){
//           System.out.println(key);
//       }
//        
        
        
        
//        try{
//            throw new NullPointerException("a");
//        }catch(RuntimeException e){
//            e.printStackTrace();
//            System.out.println(e);
//        }
        
        int a = 10;
        int c = 20;
        int b = -20;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(a^b);
        System.out.println(b^a);
    }
}
