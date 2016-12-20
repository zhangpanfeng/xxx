package com.darren.test.file.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCoverageFactorFileWriter {
    private static final String DEFAULT_DELIMITER = "|";
    private static final Map<String, String> WB_MAP = new HashMap<String, String>();
    
    public static void writeXlsx(String path, List<String> content, String delimiter) throws IOException {
        delimiter = (delimiter == null || "".equals(delimiter)) ? DEFAULT_DELIMITER : delimiter;
        FileOutputStream output = new FileOutputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");
        
        //write car
        int start = 0;
        int end = start + content.size();
        int finiahed = start;
        initCarMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write nonCar
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initNonCarMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write child
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initChildMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write nonChild
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initNonChildMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write incomeLow
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initIncomeLowMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write incomeMiddle
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initIncomeMiddleMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        //write incomeHigh
        start = start + content.size();
        end = start + content.size();
        finiahed = start;
        initIncomeHighMap();
        loopWrite(start, end, finiahed, content, delimiter, xssfSheet);
        
        xssfWorkbook.write(output);
        output.close();
    }
    
    private static void loopWrite(int start, int end, int finished, List<String> content, String delimiter, XSSFSheet xssfSheet){
        for (int rowIndex = start; rowIndex < end; rowIndex++) {
            String line = content.get(rowIndex - finished);
            String[] lineArray = line.split("\\" + delimiter);
            int col = lineArray.length;
            XSSFRow xssfRow = xssfSheet.createRow(rowIndex);
            for(int colIndex = 0; colIndex < col; colIndex++){
                XSSFCell xssfCell = xssfRow.createCell(colIndex);
                String value = WB_MAP.get(lineArray[colIndex]);
                 value = value == null ? lineArray[colIndex] : value;
                xssfCell.setCellValue(value);
            }
        }
    }
    
    private static void initCarMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_CAR");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_CAR");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_CAR");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_CAR");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_CAR");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_CAR");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_CAR");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_CAR");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_CAR");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_CAR");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_CAR");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_CAR");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_CAR");
        WB_MAP.put("MALE_15_17", "MALE_15_17_CAR");
        WB_MAP.put("MALE_18_19", "MALE_18_19_CAR");
        WB_MAP.put("MALE_20_24", "MALE_20_24_CAR");
        WB_MAP.put("MALE_25_29", "MALE_25_29_CAR");
        WB_MAP.put("MALE_30_34", "MALE_30_34_CAR");
        WB_MAP.put("MALE_35_39", "MALE_35_39_CAR");
        WB_MAP.put("MALE_40_44", "MALE_40_44_CAR");
        WB_MAP.put("MALE_45_49", "MALE_45_49_CAR");
        WB_MAP.put("MALE_50_54", "MALE_50_54_CAR");
        WB_MAP.put("MALE_55_64", "MALE_55_64_CAR");
        WB_MAP.put("MALE_65_999", "MALE_65_999_CAR");

    }
    
    private static void initNonCarMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_NONCAR");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_NONCAR");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_NONCAR");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_NONCAR");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_NONCAR");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_NONCAR");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_NONCAR");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_NONCAR");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_NONCAR");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_NONCAR");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_NONCAR");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_NONCAR");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_NONCAR");
        WB_MAP.put("MALE_15_17", "MALE_15_17_NONCAR");
        WB_MAP.put("MALE_18_19", "MALE_18_19_NONCAR");
        WB_MAP.put("MALE_20_24", "MALE_20_24_NONCAR");
        WB_MAP.put("MALE_25_29", "MALE_25_29_NONCAR");
        WB_MAP.put("MALE_30_34", "MALE_30_34_NONCAR");
        WB_MAP.put("MALE_35_39", "MALE_35_39_NONCAR");
        WB_MAP.put("MALE_40_44", "MALE_40_44_NONCAR");
        WB_MAP.put("MALE_45_49", "MALE_45_49_NONCAR");
        WB_MAP.put("MALE_50_54", "MALE_50_54_NONCAR");
        WB_MAP.put("MALE_55_64", "MALE_55_64_NONCAR");
        WB_MAP.put("MALE_65_999", "MALE_65_999_NONCAR");

    }
    
    private static void initChildMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_CHILD");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_CHILD");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_CHILD");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_CHILD");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_CHILD");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_CHILD");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_CHILD");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_CHILD");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_CHILD");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_CHILD");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_CHILD");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_CHILD");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_CHILD");
        WB_MAP.put("MALE_15_17", "MALE_15_17_CHILD");
        WB_MAP.put("MALE_18_19", "MALE_18_19_CHILD");
        WB_MAP.put("MALE_20_24", "MALE_20_24_CHILD");
        WB_MAP.put("MALE_25_29", "MALE_25_29_CHILD");
        WB_MAP.put("MALE_30_34", "MALE_30_34_CHILD");
        WB_MAP.put("MALE_35_39", "MALE_35_39_CHILD");
        WB_MAP.put("MALE_40_44", "MALE_40_44_CHILD");
        WB_MAP.put("MALE_45_49", "MALE_45_49_CHILD");
        WB_MAP.put("MALE_50_54", "MALE_50_54_CHILD");
        WB_MAP.put("MALE_55_64", "MALE_55_64_CHILD");
        WB_MAP.put("MALE_65_999", "MALE_65_999_CHILD");

    }
    
    private static void initNonChildMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_NONCHILD");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_NONCHILD");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_NONCHILD");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_NONCHILD");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_NONCHILD");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_NONCHILD");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_NONCHILD");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_NONCHILD");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_NONCHILD");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_NONCHILD");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_NONCHILD");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_NONCHILD");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_NONCHILD");
        WB_MAP.put("MALE_15_17", "MALE_15_17_NONCHILD");
        WB_MAP.put("MALE_18_19", "MALE_18_19_NONCHILD");
        WB_MAP.put("MALE_20_24", "MALE_20_24_NONCHILD");
        WB_MAP.put("MALE_25_29", "MALE_25_29_NONCHILD");
        WB_MAP.put("MALE_30_34", "MALE_30_34_NONCHILD");
        WB_MAP.put("MALE_35_39", "MALE_35_39_NONCHILD");
        WB_MAP.put("MALE_40_44", "MALE_40_44_NONCHILD");
        WB_MAP.put("MALE_45_49", "MALE_45_49_NONCHILD");
        WB_MAP.put("MALE_50_54", "MALE_50_54_NONCHILD");
        WB_MAP.put("MALE_55_64", "MALE_55_64_NONCHILD");
        WB_MAP.put("MALE_65_999", "MALE_65_999_NONCHILD");

    }
    
    private static void initIncomeLowMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_INCOMELOW");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_INCOMELOW");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_INCOMELOW");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_INCOMELOW");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_INCOMELOW");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_INCOMELOW");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_INCOMELOW");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_INCOMELOW");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_INCOMELOW");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_INCOMELOW");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_INCOMELOW");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_INCOMELOW");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_INCOMELOW");
        WB_MAP.put("MALE_15_17", "MALE_15_17_INCOMELOW");
        WB_MAP.put("MALE_18_19", "MALE_18_19_INCOMELOW");
        WB_MAP.put("MALE_20_24", "MALE_20_24_INCOMELOW");
        WB_MAP.put("MALE_25_29", "MALE_25_29_INCOMELOW");
        WB_MAP.put("MALE_30_34", "MALE_30_34_INCOMELOW");
        WB_MAP.put("MALE_35_39", "MALE_35_39_INCOMELOW");
        WB_MAP.put("MALE_40_44", "MALE_40_44_INCOMELOW");
        WB_MAP.put("MALE_45_49", "MALE_45_49_INCOMELOW");
        WB_MAP.put("MALE_50_54", "MALE_50_54_INCOMELOW");
        WB_MAP.put("MALE_55_64", "MALE_55_64_INCOMELOW");
        WB_MAP.put("MALE_65_999", "MALE_65_999_INCOMELOW");

    }
    
    private static void initIncomeMiddleMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_INCOMEMIDDLE");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_INCOMEMIDDLE");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_INCOMEMIDDLE");
        WB_MAP.put("MALE_15_17", "MALE_15_17_INCOMEMIDDLE");
        WB_MAP.put("MALE_18_19", "MALE_18_19_INCOMEMIDDLE");
        WB_MAP.put("MALE_20_24", "MALE_20_24_INCOMEMIDDLE");
        WB_MAP.put("MALE_25_29", "MALE_25_29_INCOMEMIDDLE");
        WB_MAP.put("MALE_30_34", "MALE_30_34_INCOMEMIDDLE");
        WB_MAP.put("MALE_35_39", "MALE_35_39_INCOMEMIDDLE");
        WB_MAP.put("MALE_40_44", "MALE_40_44_INCOMEMIDDLE");
        WB_MAP.put("MALE_45_49", "MALE_45_49_INCOMEMIDDLE");
        WB_MAP.put("MALE_50_54", "MALE_50_54_INCOMEMIDDLE");
        WB_MAP.put("MALE_55_64", "MALE_55_64_INCOMEMIDDLE");
        WB_MAP.put("MALE_65_999", "MALE_65_999_INCOMEMIDDLE");

    }
    
    private static void initIncomeHighMap(){
        WB_MAP.clear();
        WB_MAP.put("FEMALE_05_14", "FEMALE_05_14_INCOMEHIGH");
        WB_MAP.put("FEMALE_15_17", "FEMALE_15_17_INCOMEHIGH");
        WB_MAP.put("FEMALE_18_19", "FEMALE_18_19_INCOMEHIGH");
        WB_MAP.put("FEMALE_20_24", "FEMALE_20_24_INCOMEHIGH");
        WB_MAP.put("FEMALE_25_29", "FEMALE_25_29_INCOMEHIGH");
        WB_MAP.put("FEMALE_30_34", "FEMALE_30_34_INCOMEHIGH");
        WB_MAP.put("FEMALE_35_39", "FEMALE_35_39_INCOMEHIGH");
        WB_MAP.put("FEMALE_40_44", "FEMALE_40_44_INCOMEHIGH");
        WB_MAP.put("FEMALE_45_49", "FEMALE_45_49_INCOMEHIGH");
        WB_MAP.put("FEMALE_50_54", "FEMALE_50_54_INCOMEHIGH");
        WB_MAP.put("FEMALE_55_64", "FEMALE_55_64_INCOMEHIGH");
        WB_MAP.put("FEMALE_65_999", "FEMALE_65_999_INCOMEHIGH");
        
        WB_MAP.put("MALE_05_14", "MALE_05_14_INCOMEHIGH");
        WB_MAP.put("MALE_15_17", "MALE_15_17_INCOMEHIGH");
        WB_MAP.put("MALE_18_19", "MALE_18_19_INCOMEHIGH");
        WB_MAP.put("MALE_20_24", "MALE_20_24_INCOMEHIGH");
        WB_MAP.put("MALE_25_29", "MALE_25_29_INCOMEHIGH");
        WB_MAP.put("MALE_30_34", "MALE_30_34_INCOMEHIGH");
        WB_MAP.put("MALE_35_39", "MALE_35_39_INCOMEHIGH");
        WB_MAP.put("MALE_40_44", "MALE_40_44_INCOMEHIGH");
        WB_MAP.put("MALE_45_49", "MALE_45_49_INCOMEHIGH");
        WB_MAP.put("MALE_50_54", "MALE_50_54_INCOMEHIGH");
        WB_MAP.put("MALE_55_64", "MALE_55_64_INCOMEHIGH");
        WB_MAP.put("MALE_65_999", "MALE_65_999_INCOMEHIGH");

    }
}
