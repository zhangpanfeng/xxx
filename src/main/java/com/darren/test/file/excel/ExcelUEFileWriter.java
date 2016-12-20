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

public class ExcelUEFileWriter {
    private static final String DEFAULT_DELIMITER = "|";
    private static final Map<String, String> WB_MAP = new HashMap<String, String>();
    
    static{
//        initCarMap();
//        initNonCarMap();
//        initChildMap();
//        initNonChildMap();
//        initIncomeLowMap();
//        initIncomeMiddleMap();
        initIncomeHighMap();
    }
    

    public static void writeXlsx(String path, List<String> content, String delimiter) throws IOException {
        delimiter = (delimiter == null || "".equals(delimiter)) ? DEFAULT_DELIMITER : delimiter;
        FileOutputStream output = new FileOutputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");
        int row = content.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            String line = content.get(rowIndex);
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
        
        xssfWorkbook.write(output);
        output.close();
    }
    
    private static void initCarMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_CAR");
        WB_MAP.put("15.0", "FEMALE_15_17_CAR");
        WB_MAP.put("18.0", "FEMALE_18_19_CAR");
        WB_MAP.put("20.0", "FEMALE_20_24_CAR");
        WB_MAP.put("25.0", "FEMALE_25_29_CAR");
        WB_MAP.put("30.0", "FEMALE_30_34_CAR");
        WB_MAP.put("35.0", "FEMALE_35_39_CAR");
        WB_MAP.put("40.0", "FEMALE_40_44_CAR");
        WB_MAP.put("45.0", "FEMALE_45_49_CAR");
        WB_MAP.put("50.0", "FEMALE_50_54_CAR");
        WB_MAP.put("55.0", "FEMALE_55_64_CAR");
        WB_MAP.put("65.0", "FEMALE_65_999_CAR");
        
        WB_MAP.put("105.0", "MALE_05_14_CAR");
        WB_MAP.put("115.0", "MALE_15_17_CAR");
        WB_MAP.put("118.0", "MALE_18_19_CAR");
        WB_MAP.put("120.0", "MALE_20_24_CAR");
        WB_MAP.put("125.0", "MALE_25_29_CAR");
        WB_MAP.put("130.0", "MALE_30_34_CAR");
        WB_MAP.put("135.0", "MALE_35_39_CAR");
        WB_MAP.put("140.0", "MALE_40_44_CAR");
        WB_MAP.put("145.0", "MALE_45_49_CAR");
        WB_MAP.put("150.0", "MALE_50_54_CAR");
        WB_MAP.put("155.0", "MALE_55_64_CAR");
        WB_MAP.put("165.0", "MALE_65_999_CAR");

    }
    
    private static void initNonCarMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_NONCAR");
        WB_MAP.put("15.0", "FEMALE_15_17_NONCAR");
        WB_MAP.put("18.0", "FEMALE_18_19_NONCAR");
        WB_MAP.put("20.0", "FEMALE_20_24_NONCAR");
        WB_MAP.put("25.0", "FEMALE_25_29_NONCAR");
        WB_MAP.put("30.0", "FEMALE_30_34_NONCAR");
        WB_MAP.put("35.0", "FEMALE_35_39_NONCAR");
        WB_MAP.put("40.0", "FEMALE_40_44_NONCAR");
        WB_MAP.put("45.0", "FEMALE_45_49_NONCAR");
        WB_MAP.put("50.0", "FEMALE_50_54_NONCAR");
        WB_MAP.put("55.0", "FEMALE_55_64_NONCAR");
        WB_MAP.put("65.0", "FEMALE_65_999_NONCAR");
        
        WB_MAP.put("105.0", "MALE_05_14_NONCAR");
        WB_MAP.put("115.0", "MALE_15_17_NONCAR");
        WB_MAP.put("118.0", "MALE_18_19_NONCAR");
        WB_MAP.put("120.0", "MALE_20_24_NONCAR");
        WB_MAP.put("125.0", "MALE_25_29_NONCAR");
        WB_MAP.put("130.0", "MALE_30_34_NONCAR");
        WB_MAP.put("135.0", "MALE_35_39_NONCAR");
        WB_MAP.put("140.0", "MALE_40_44_NONCAR");
        WB_MAP.put("145.0", "MALE_45_49_NONCAR");
        WB_MAP.put("150.0", "MALE_50_54_NONCAR");
        WB_MAP.put("155.0", "MALE_55_64_NONCAR");
        WB_MAP.put("165.0", "MALE_65_999_NONCAR");

    }
    
    private static void initChildMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_CHILD");
        WB_MAP.put("15.0", "FEMALE_15_17_CHILD");
        WB_MAP.put("18.0", "FEMALE_18_19_CHILD");
        WB_MAP.put("20.0", "FEMALE_20_24_CHILD");
        WB_MAP.put("25.0", "FEMALE_25_29_CHILD");
        WB_MAP.put("30.0", "FEMALE_30_34_CHILD");
        WB_MAP.put("35.0", "FEMALE_35_39_CHILD");
        WB_MAP.put("40.0", "FEMALE_40_44_CHILD");
        WB_MAP.put("45.0", "FEMALE_45_49_CHILD");
        WB_MAP.put("50.0", "FEMALE_50_54_CHILD");
        WB_MAP.put("55.0", "FEMALE_55_64_CHILD");
        WB_MAP.put("65.0", "FEMALE_65_999_CHILD");
        
        WB_MAP.put("105.0", "MALE_05_14_CHILD");
        WB_MAP.put("115.0", "MALE_15_17_CHILD");
        WB_MAP.put("118.0", "MALE_18_19_CHILD");
        WB_MAP.put("120.0", "MALE_20_24_CHILD");
        WB_MAP.put("125.0", "MALE_25_29_CHILD");
        WB_MAP.put("130.0", "MALE_30_34_CHILD");
        WB_MAP.put("135.0", "MALE_35_39_CHILD");
        WB_MAP.put("140.0", "MALE_40_44_CHILD");
        WB_MAP.put("145.0", "MALE_45_49_CHILD");
        WB_MAP.put("150.0", "MALE_50_54_CHILD");
        WB_MAP.put("155.0", "MALE_55_64_CHILD");
        WB_MAP.put("165.0", "MALE_65_999_CHILD");

    }
    
    private static void initNonChildMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_NONCHILD");
        WB_MAP.put("15.0", "FEMALE_15_17_NONCHILD");
        WB_MAP.put("18.0", "FEMALE_18_19_NONCHILD");
        WB_MAP.put("20.0", "FEMALE_20_24_NONCHILD");
        WB_MAP.put("25.0", "FEMALE_25_29_NONCHILD");
        WB_MAP.put("30.0", "FEMALE_30_34_NONCHILD");
        WB_MAP.put("35.0", "FEMALE_35_39_NONCHILD");
        WB_MAP.put("40.0", "FEMALE_40_44_NONCHILD");
        WB_MAP.put("45.0", "FEMALE_45_49_NONCHILD");
        WB_MAP.put("50.0", "FEMALE_50_54_NONCHILD");
        WB_MAP.put("55.0", "FEMALE_55_64_NONCHILD");
        WB_MAP.put("65.0", "FEMALE_65_999_NONCHILD");
        
        WB_MAP.put("105.0", "MALE_05_14_NONCHILD");
        WB_MAP.put("115.0", "MALE_15_17_NONCHILD");
        WB_MAP.put("118.0", "MALE_18_19_NONCHILD");
        WB_MAP.put("120.0", "MALE_20_24_NONCHILD");
        WB_MAP.put("125.0", "MALE_25_29_NONCHILD");
        WB_MAP.put("130.0", "MALE_30_34_NONCHILD");
        WB_MAP.put("135.0", "MALE_35_39_NONCHILD");
        WB_MAP.put("140.0", "MALE_40_44_NONCHILD");
        WB_MAP.put("145.0", "MALE_45_49_NONCHILD");
        WB_MAP.put("150.0", "MALE_50_54_NONCHILD");
        WB_MAP.put("155.0", "MALE_55_64_NONCHILD");
        WB_MAP.put("165.0", "MALE_65_999_NONCHILD");

    }
    
    private static void initIncomeLowMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_INCOMELOW");
        WB_MAP.put("15.0", "FEMALE_15_17_INCOMELOW");
        WB_MAP.put("18.0", "FEMALE_18_19_INCOMELOW");
        WB_MAP.put("20.0", "FEMALE_20_24_INCOMELOW");
        WB_MAP.put("25.0", "FEMALE_25_29_INCOMELOW");
        WB_MAP.put("30.0", "FEMALE_30_34_INCOMELOW");
        WB_MAP.put("35.0", "FEMALE_35_39_INCOMELOW");
        WB_MAP.put("40.0", "FEMALE_40_44_INCOMELOW");
        WB_MAP.put("45.0", "FEMALE_45_49_INCOMELOW");
        WB_MAP.put("50.0", "FEMALE_50_54_INCOMELOW");
        WB_MAP.put("55.0", "FEMALE_55_64_INCOMELOW");
        WB_MAP.put("65.0", "FEMALE_65_999_INCOMELOW");
        
        WB_MAP.put("105.0", "MALE_05_14_INCOMELOW");
        WB_MAP.put("115.0", "MALE_15_17_INCOMELOW");
        WB_MAP.put("118.0", "MALE_18_19_INCOMELOW");
        WB_MAP.put("120.0", "MALE_20_24_INCOMELOW");
        WB_MAP.put("125.0", "MALE_25_29_INCOMELOW");
        WB_MAP.put("130.0", "MALE_30_34_INCOMELOW");
        WB_MAP.put("135.0", "MALE_35_39_INCOMELOW");
        WB_MAP.put("140.0", "MALE_40_44_INCOMELOW");
        WB_MAP.put("145.0", "MALE_45_49_INCOMELOW");
        WB_MAP.put("150.0", "MALE_50_54_INCOMELOW");
        WB_MAP.put("155.0", "MALE_55_64_INCOMELOW");
        WB_MAP.put("165.0", "MALE_65_999_INCOMELOW");

    }
    
    private static void initIncomeMiddleMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_INCOMEMIDDLE");
        WB_MAP.put("15.0", "FEMALE_15_17_INCOMEMIDDLE");
        WB_MAP.put("18.0", "FEMALE_18_19_INCOMEMIDDLE");
        WB_MAP.put("20.0", "FEMALE_20_24_INCOMEMIDDLE");
        WB_MAP.put("25.0", "FEMALE_25_29_INCOMEMIDDLE");
        WB_MAP.put("30.0", "FEMALE_30_34_INCOMEMIDDLE");
        WB_MAP.put("35.0", "FEMALE_35_39_INCOMEMIDDLE");
        WB_MAP.put("40.0", "FEMALE_40_44_INCOMEMIDDLE");
        WB_MAP.put("45.0", "FEMALE_45_49_INCOMEMIDDLE");
        WB_MAP.put("50.0", "FEMALE_50_54_INCOMEMIDDLE");
        WB_MAP.put("55.0", "FEMALE_55_64_INCOMEMIDDLE");
        WB_MAP.put("65.0", "FEMALE_65_999_INCOMEMIDDLE");
        
        WB_MAP.put("105.0", "MALE_05_14_INCOMEMIDDLE");
        WB_MAP.put("115.0", "MALE_15_17_INCOMEMIDDLE");
        WB_MAP.put("118.0", "MALE_18_19_INCOMEMIDDLE");
        WB_MAP.put("120.0", "MALE_20_24_INCOMEMIDDLE");
        WB_MAP.put("125.0", "MALE_25_29_INCOMEMIDDLE");
        WB_MAP.put("130.0", "MALE_30_34_INCOMEMIDDLE");
        WB_MAP.put("135.0", "MALE_35_39_INCOMEMIDDLE");
        WB_MAP.put("140.0", "MALE_40_44_INCOMEMIDDLE");
        WB_MAP.put("145.0", "MALE_45_49_INCOMEMIDDLE");
        WB_MAP.put("150.0", "MALE_50_54_INCOMEMIDDLE");
        WB_MAP.put("155.0", "MALE_55_64_INCOMEMIDDLE");
        WB_MAP.put("165.0", "MALE_65_999_INCOMEMIDDLE");

    }
    
    private static void initIncomeHighMap(){
        WB_MAP.put("5.0", "FEMALE_05_14_INCOMEHIGH");
        WB_MAP.put("15.0", "FEMALE_15_17_INCOMEHIGH");
        WB_MAP.put("18.0", "FEMALE_18_19_INCOMEHIGH");
        WB_MAP.put("20.0", "FEMALE_20_24_INCOMEHIGH");
        WB_MAP.put("25.0", "FEMALE_25_29_INCOMEHIGH");
        WB_MAP.put("30.0", "FEMALE_30_34_INCOMEHIGH");
        WB_MAP.put("35.0", "FEMALE_35_39_INCOMEHIGH");
        WB_MAP.put("40.0", "FEMALE_40_44_INCOMEHIGH");
        WB_MAP.put("45.0", "FEMALE_45_49_INCOMEHIGH");
        WB_MAP.put("50.0", "FEMALE_50_54_INCOMEHIGH");
        WB_MAP.put("55.0", "FEMALE_55_64_INCOMEHIGH");
        WB_MAP.put("65.0", "FEMALE_65_999_INCOMEHIGH");
        
        WB_MAP.put("105.0", "MALE_05_14_INCOMEHIGH");
        WB_MAP.put("115.0", "MALE_15_17_INCOMEHIGH");
        WB_MAP.put("118.0", "MALE_18_19_INCOMEHIGH");
        WB_MAP.put("120.0", "MALE_20_24_INCOMEHIGH");
        WB_MAP.put("125.0", "MALE_25_29_INCOMEHIGH");
        WB_MAP.put("130.0", "MALE_30_34_INCOMEHIGH");
        WB_MAP.put("135.0", "MALE_35_39_INCOMEHIGH");
        WB_MAP.put("140.0", "MALE_40_44_INCOMEHIGH");
        WB_MAP.put("145.0", "MALE_45_49_INCOMEHIGH");
        WB_MAP.put("150.0", "MALE_50_54_INCOMEHIGH");
        WB_MAP.put("155.0", "MALE_55_64_INCOMEHIGH");
        WB_MAP.put("165.0", "MALE_65_999_INCOMEHIGH");

    }
    
}
