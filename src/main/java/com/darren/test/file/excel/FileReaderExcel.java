package com.darren.test.file.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReaderExcel {

    public List<ExcelEntity> readExcel(String path) throws IOException {
        if (path == null || CommonUtil.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = CommonUtil.getPostfix(path);
            if (!CommonUtil.EMPTY.equals(postfix)) {
                if (CommonUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path);
                } else if (CommonUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path);
                }
            } else {
                System.out.println(path + CommonUtil.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    // test
    /**
     * Read the Excel 2010
     * 
     * @param File
     * @return
     * @throws IOException
     */
    public List<ExcelEntity> readXlsx(InputStream input) throws IOException {
        @SuppressWarnings("resource")
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
        ExcelEntity excelEntity = null;
        List<ExcelEntity> list = new ArrayList<ExcelEntity>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    excelEntity = new ExcelEntity();
                    XSSFCell field1 = xssfRow.getCell(0);
                    XSSFCell field2 = xssfRow.getCell(1);
                    XSSFCell field3 = xssfRow.getCell(2);
                    XSSFCell field4 = xssfRow.getCell(3);
                    XSSFCell field5 = xssfRow.getCell(4);
                    XSSFCell field6 = xssfRow.getCell(5);
                    excelEntity.setField1(getValue(field1));
                    excelEntity.setField2(getValue(field2));
                    excelEntity.setField3(getValue(field3));
                    excelEntity.setField4(getValue(field4));
                    excelEntity.setField5(getValue(field5));
                    excelEntity.setField6(getValue(field6));
                    list.add(excelEntity);
                }
            }
        }
        return list;
    }

    /**
     * Read the Excel 2010
     * 
     * @param path
     *            the path of the excel file
     * @return
     * @throws IOException
     */
    public List<ExcelEntity> readXlsx(String path) throws IOException {
        System.out.println(CommonUtil.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExcelEntity excelEntity = null;
        List<ExcelEntity> list = new ArrayList<ExcelEntity>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    excelEntity = new ExcelEntity();
                    XSSFCell field1 = xssfRow.getCell(0);
                    XSSFCell field2 = xssfRow.getCell(1);
                    XSSFCell field3 = xssfRow.getCell(2);
                    XSSFCell field4 = xssfRow.getCell(3);
                    XSSFCell field5 = xssfRow.getCell(4);
                    XSSFCell field6 = xssfRow.getCell(5);
                    excelEntity.setField1(getValue(field1));
                    excelEntity.setField2(getValue(field2));
                    excelEntity.setField3(getValue(field3));
                    excelEntity.setField4(getValue(field4));
                    excelEntity.setField5(getValue(field5));
                    excelEntity.setField6(getValue(field6));
                    list.add(excelEntity);
                }
            }
        }
        return list;
    }

    /**
     * Read the Excel 2003-2007
     * 
     * @param path
     *            the path of the Excel
     * @return
     * @throws IOException
     */
    public List<ExcelEntity> readXls(String path) throws IOException {
        System.out.println(CommonUtil.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        ExcelEntity excelEntity = null;
        List<ExcelEntity> list = new ArrayList<ExcelEntity>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    excelEntity = new ExcelEntity();
                    HSSFCell field1 = hssfRow.getCell(0);
                    HSSFCell field2 = hssfRow.getCell(1);
                    HSSFCell field3 = hssfRow.getCell(2);
                    HSSFCell field4 = hssfRow.getCell(3);
                    HSSFCell field5 = hssfRow.getCell(4);
                    HSSFCell field6 = hssfRow.getCell(5);
                    excelEntity.setField1(getValue(field1));
                    excelEntity.setField2(getValue(field2));
                    excelEntity.setField3(getValue(field3));
                    excelEntity.setField4(getValue(field4));
                    excelEntity.setField5(getValue(field5));
                    excelEntity.setField6(getValue(field6));
                    list.add(excelEntity);
                }
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if(xssfRow == null){
            return null;
        }
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
