package com.darren.test.file.excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReadExcelTest2 {
    private static final String BASE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        readAndWriteReportableDemographic();
//         readAndWriteDemographicPlus();
//         readAndWriteReportableDemographicToDemographic();
//         readAndWriteProviderAggregationType();
         readAndWriteProviderAggregationToAggregation();
    }

    public static void readAndWriteReportableDemographic() {
        String sourcePath = BASE_PATH + "reportable_demographic.xlsx";
        String targetPath = BASE_PATH + "reportable_demographic_2016-12-06.txt";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder();
                builder.append(Double.valueOf(excelEntity.getField1()).intValue()).append("|");
                builder.append(excelEntity.getField2()).append("|");
                builder.append(excelEntity.getField2()).append("|");
                builder.append(FORMATTER.format(new Date())).append("|");
                builder.append("3000-12-31").append("|");
                builder.append("2015-01-01").append("|");
                builder.append("Y");
                writer.writeFile(builder.toString());
                writer.newLine();
                System.out.println(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteDemographicPlus() {
        String sourcePath = BASE_PATH + "demofraphic_plus_v2.xlsx";
        String targetPath = BASE_PATH + "demofraphic_plus_2016-12-05.txt";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder();
                builder.append(Double.valueOf(excelEntity.getField1()).intValue()).append("|");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append("|");
                builder.append(excelEntity.getField3()).append("|");
                builder.append(excelEntity.getField4()).append("|");
                builder.append(excelEntity.getField5()).append("|");
                builder.append(FORMATTER.format(new Date()));
                writer.writeFile(builder.toString());
                writer.newLine();
                System.out.println(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteReportableDemographicToDemographic() {
        String sourcePath = BASE_PATH + "reportable_demographic_to_demographic_v2.xlsx";
        String targetPath = BASE_PATH + "reportable_demographic_to_demographic_2016-12-06.txt";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder();
                builder.append(Double.valueOf(excelEntity.getField1()).intValue()).append("|");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append("|");
                builder.append(excelEntity.getField3()).append("|");
                builder.append(excelEntity.getField4()).append("|");
                builder.append(FORMATTER.format(new Date())).append("|");
                builder.append(excelEntity.getField5());
                
                writer.writeFile(builder.toString());
                writer.newLine();
                System.out.println(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteProviderAggregationType() {
        String sourcePath = BASE_PATH + "provider_aggregation_type.xlsx";
        String targetPath = BASE_PATH + "provider_aggregation_type_2016-12-06.txt";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder();
                builder.append(Double.valueOf(excelEntity.getField1()).intValue()).append("|");
                builder.append(excelEntity.getField2()).append("|");
                builder.append(excelEntity.getField3().trim()).append("|");
                builder.append(Double.valueOf(excelEntity.getField4()).intValue());
                
                writer.writeFile(builder.toString());
                writer.newLine();
                System.out.println(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteProviderAggregationToAggregation() {
        String sourcePath = BASE_PATH + "provider_aggregation_to_aggregation.xlsx";
        String targetPath = BASE_PATH + "provider_aggregation_to_aggregation_2016-12-06.txt";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder();
                builder.append(Double.valueOf(excelEntity.getField1()).intValue()).append("|");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append("|");
                builder.append(excelEntity.getField3()).append("|");
                builder.append(excelEntity.getField4().trim()).append("|");
                builder.append(excelEntity.getField5());
                
                writer.writeFile(builder.toString());
                writer.newLine();
                System.out.println(builder.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
