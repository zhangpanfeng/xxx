package com.darren.test.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLoop {

    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        int i=0;
        List<String> sList = new ArrayList<>();
        try{
            //List<Map<String, Object>> list = new ArrayList<>();
            long startMem = run.totalMemory()-run.freeMemory();
            System.out.println("start = " + startMem);
            for (; i < 7930776; i++) {
                //System.out.println(1);
//                Map<String, Object> map = generateGroup();
              //  list.add(map);
                sList.add("darrenaaaaaa bbbbbbbbbb ccccccccccccccccccc dddddddddddddddddd eeeeeeeeeeeeeeeeeeeee fffffffffffffffff" + i);
                System.out.println(i);
            }
            long endMem = run.totalMemory()-run.freeMemory();
            System.out.println("end = " + endMem);
        }catch(Exception e){
            System.out.println(i);
            e.printStackTrace();
        }finally{
            long endMem = run.totalMemory()-run.freeMemory();
            System.out.println("end = " + endMem);
        }
        

    }

    private static Map<String, Object> generateGroup() {
        Map<String, Object> group = new HashMap<String, Object>();
        group.put("nielsen_campaign_id", "aaa");
        group.put("site_id", "combinationKey.getSiteId()");
        group.put("nielsen_placement_id", "array[11]");
        group.put("reportable_dma_id", "array[11]");
        group.put("demographic_id", "Integer.parseInt(array[0])");
        group.put("aggregation_type", "Integer.parseInt(combinationKey.getAggregationType())");
        group.put("geography_code", "Integer.parseInt(combinationKey.getGeographyCode())");
        group.put("frequency", "combinationKey.getFrequency()");
        group.put("desktop_unique_audience", "Double.parseDouble(array[1])");
        group.put("desktop_impressions", "Double.parseDouble(array[2])");
        group.put("mobile_unique_audience", "Double.parseDouble(array[3])");
        group.put("mobile_impressions", "Double.parseDouble(array[4])");
        group.put("ott_unique_audience", "Double.parseDouble(array[5])");
        group.put("ott_impressions", "Double.parseDouble(array[6])");
        group.put("total_unique_audience", "Double.parseDouble(array[7])");
        group.put("total_impressions", "Double.parseDouble(array[8])");
        group.put("desktop_impressions_percent", "pcPercent");
        group.put("mobile_impressions_percent", "mblPercent");
        group.put("ott_impressions_percent", "ottPercent");
        group.put("total_impressions_percent", "totalPercent");
        group.put("universe_estimate", "Double.parseDouble(array[9])");
        group.put("intab_period_id", "Long.parseLong(array[10])");

        return group;
    }
}
