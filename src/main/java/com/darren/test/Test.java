package com.darren.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("non_car_owner", "non_car_owner");
        map.put("car_owner", "car_owner");

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }
    }

}
