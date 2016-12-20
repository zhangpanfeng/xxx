package com.darren.test.file.excel;

import java.io.IOException;
import java.util.List;

public class ReadExcelTest {
    private static final String BASE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";

    public static void main(String[] args) {
//         readAndWriteReportableDemographic();
//         readAndWriteDemographicPlus();
         readAndWriteReportableDemographicToDemographic();
        // readAndWriteProviderAggregationType();
//        readAndWriteProviderAggregationToAggregation();
    }

    public static void readAndWriteReportableDemographic() {
        String sourcePath = BASE_PATH + "reportable_demographic.xlsx";
        String targetPath = BASE_PATH + "reportable_demographic.sql";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder("insert into reportable_demographic ");
                builder.append("(").append("reportable_demographic_id, ").append("reportable_demographic_desc, ");
                builder.append("name, ").append("creation_datetime, ").append("effective_end_date, ")
                        .append("effective_start_date, ");
                builder.append("released_for_processing_flag").append(") ");
                builder.append("values (").append(Double.valueOf(excelEntity.getField1()).intValue()).append(", ");
                builder.append("'" + excelEntity.getField2() + "'").append(", ");
                builder.append("'" + excelEntity.getField2() + "'").append(", ");
                builder.append("from_unixtime(unix_timestamp(), 'yyyy-MM-dd HH:mm:ss')").append(", ");
                builder.append("'3000-12-31'").append(", ");
                builder.append("'2015-01-01'").append(", ");
                builder.append("'Y'").append(");");

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
        String sourcePath = BASE_PATH + "demofraphic_plus.xlsx";
        String targetPath = BASE_PATH + "demofraphic_plus.sql";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder("insert into demographic_plus ");
                builder.append("(").append("demographic_id, ").append("original_demographic_id, ");
                builder.append("name, ").append("demo_name, ").append("demo_value, ");
                builder.append("creation_datetime").append(") ");
                builder.append("values (").append(Double.valueOf(excelEntity.getField1()).intValue()).append(", ");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append(", ");
                builder.append("'" + excelEntity.getField3() + "'").append(", ");
                builder.append("'" + excelEntity.getField4() + "'").append(", ");
                builder.append("'" + excelEntity.getField5() + "'").append(", ");
                builder.append("from_unixtime(unix_timestamp(), 'yyyy-MM-dd HH:mm:ss')");
                builder.append(");");

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
        String sourcePath = BASE_PATH + "reportable_demographic_to_demographic.xlsx";
        String targetPath = BASE_PATH + "reportable_demographic_to_demographic.sql";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder("insert into reportable_demographic_to_demographic ");
                builder.append("(").append("reportable_demographic_id, ").append("demographic_id, ");
                builder.append("effective_start_date, ").append("effective_end_date, ");
                builder.append("creation_datetime, ").append("ue_subtotal_flag").append(") ");
                builder.append("values (").append(Double.valueOf(excelEntity.getField1()).intValue()).append(", ");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append(", ");
                builder.append("'" + excelEntity.getField3() + "'").append(", ");
                builder.append("'" + excelEntity.getField4() + "'").append(", ");
                builder.append("from_unixtime(unix_timestamp(), 'yyyy-MM-dd HH:mm:ss')").append(", ");
                builder.append("'" + excelEntity.getField5() + "'");
                builder.append(");");

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
        String targetPath = BASE_PATH + "provider_aggregation_type.sql";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder("insert into provider_aggregation_type ");
                builder.append("(").append("aggregation_type_code, ").append("aggregation_type_name, ");
                builder.append("aggregation_type_desc, ").append("provider_id").append(") ");
                builder.append("values (").append(Double.valueOf(excelEntity.getField1()).intValue()).append(", ");
                builder.append("'" + excelEntity.getField2() + "'").append(", ");
                builder.append("'" + excelEntity.getField3().trim() + "'").append(", ");
                builder.append(Double.valueOf(excelEntity.getField4()).intValue());
                builder.append(");");

                writer.writeFile(builder.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWriteProviderAggregationToAggregation() {
        String sourcePath = BASE_PATH + "provider_aggregation_to_aggregation.xlsx";
        String targetPath = BASE_PATH + "provider_aggregation_to_aggregation.sql";
        FileWriter writer = new FileWriter(targetPath);
        try {
            List<ExcelEntity> result = new FileReaderExcel().readXlsx(sourcePath);
            for (ExcelEntity excelEntity : result) {
                StringBuilder builder = new StringBuilder("insert into provider_aggregation_to_aggregation ");
                builder.append("(").append("provider_aggregation_type_code, ").append("aggregation_type_code, ");
                builder.append("effective_start_date, ").append("effective_end_date, ");
                builder.append("released_for_processing_flag").append(") ");
                builder.append("values (").append(Double.valueOf(excelEntity.getField1()).intValue()).append(", ");
                builder.append(Double.valueOf(excelEntity.getField2()).intValue()).append(", ");
                builder.append("'" + excelEntity.getField3() + "'").append(", ");
                builder.append("'" + excelEntity.getField4().trim() + "'").append(", ");
                builder.append("'" + excelEntity.getField5() + "'");
                builder.append(");");

                writer.writeFile(builder.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
