package com.darren.test.file.excel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExcelFileTest {
    private static final String BASE_PATH = System.getProperty("user.dir") + "\\files\\";
    public static void main(String[] args) {
        
//        readUE();
        readDeviceSharing();
//        readCoverageFactor();
    }

    private static void readUE(){
        String sourcePath = BASE_PATH + "China DAR UE_20161114.xlsx";
        String targetPath = BASE_PATH + "wb_ue.xlsx";
        try{
            
          Map<String, List<String>> result =  ExcelFileReader.readXlsx(sourcePath, null);
          Collection<List<String>> resultList = result.values();
          for(List<String> list : resultList){
//              for(String line: list){
//                  System.out.println(line);
//              }
              ExcelUEFileWriter.writeXlsx(targetPath, list, "|");
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void readDeviceSharing(){
        String sourcePath = BASE_PATH + "Sharing_factor_sample.xlsx";
        String targetPath = BASE_PATH + "Device Sharing input file for WB.xlsx";
        try{
            
          Map<String, List<String>> result =  ExcelFileReader.readXlsx(sourcePath, null);
          Collection<List<String>> resultList = result.values();
          for(List<String> list : resultList){
//              for(String line: list){
//                  System.out.println(line);
//              }
              ExcelDeviceSharingFileWriter.writeXlsx(targetPath, list, "|");
          }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void readCoverageFactor(){
        String sourcePath = BASE_PATH + "Adjustment_factor_sample.xlsx";
        String targetPath = BASE_PATH + "Coverage Factor input file for WB.xlsx";
        try{
            
            Map<String, List<String>> result =  ExcelFileReader.readXlsx(sourcePath, null);
            Collection<List<String>> resultList = result.values();
            for(List<String> list : resultList){
//                for(String line: list){
//                    System.out.println(line);
//                }
                ExcelDeviceSharingFileWriter.writeXlsx(targetPath, list, "|");
            }
          }catch(Exception e){
              e.printStackTrace();
          }
    }
}
