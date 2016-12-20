package com.darren.test.file.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
    private static final String DEFAULT_DELIMITER = "|";
    private static final String DEFAULT_SUFFIX = "xlsx";

    public static List<String> readExcel(String path, String delimiter) {
        List<String> result = new ArrayList<String>();

        return result;
    }

    public static List<String> readExcel(InputStream input, String fileNameSuffix, String delimiter) {
        List<String> result = new ArrayList<String>();

        return result;
    }

    public static Map<String, List<String>> readXlsx(String path, String delimiter) throws IOException {
        InputStream input = new FileInputStream(path);

        return readXlsx(input, delimiter, 0, 0, 1, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
    }

    public static List<String> readXls(String path, String delimiter) {
        List<String> result = new ArrayList<String>();

        return result;
    }

    /**
     * Read the Excel 2010
     * 
     * @param input
     *            File input stream
     * @param delimiter
     *            Field delimiter default value is "|"
     * @param startSheetIndex
     *            value [0 1 2 ...]
     * @param endSheetIndex
     *            value [1 2 ...]
     * @param startLine
     *            value [0 1 2 ...] 0 contains header, 1 doesn't contains header
     * @param endLine
     *            value [1 2 3 ...]
     * @param startColumnIndex
     *            value [0 1 2 ...]
     * @param endColumnIndex
     *            value [1 2 3 ...]
     * @return Map contains all the sheet, sheet name is the key, sheet content
     *         is the List<String>
     * 
     * @throws IOException
     */
    @SuppressWarnings("resource")
    public static Map<String, List<String>> readXlsx(InputStream input, String delimiter, int startSheetIndex,
            int endSheetIndex, int startLine, int endLine, int startColumnIndex, int endColumnIndex)
            throws IOException {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        delimiter = (delimiter == null || "".equals(delimiter)) ? DEFAULT_DELIMITER : delimiter;
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(input);
        int sheetCount = xssfWorkbook.getNumberOfSheets();
        if (startSheetIndex < 0 || startSheetIndex > sheetCount || startSheetIndex > endSheetIndex || startLine < 0
                || startLine > endLine || startColumnIndex < 0 || startColumnIndex > endColumnIndex) {
            System.out.println("Parameter error!");
            return result;
        }
        endSheetIndex = endSheetIndex > sheetCount -1 ? sheetCount-1 : endSheetIndex;

        // Read the Sheet
        for (int sheetIndex = startSheetIndex; sheetIndex <= endSheetIndex; sheetIndex++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(sheetIndex);
            if (xssfSheet == null) {
                continue;
            }
            String sheetName = xssfSheet.getSheetName();

            List<String> list = new ArrayList<String>();
            int rowCount = xssfSheet.getLastRowNum();
            endLine = endLine > rowCount ? rowCount : endLine;
            // Read the Row
            for (int rowIndex = startLine; rowIndex <= endLine; rowIndex++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowIndex);
                if (xssfRow != null) {
                    int columnCount = xssfRow.getPhysicalNumberOfCells();
                    endColumnIndex = endColumnIndex > columnCount-1 ? columnCount-1 : endColumnIndex;
                    StringBuilder builder = new StringBuilder();
                    for (int columnIndex = startColumnIndex; columnIndex <= endColumnIndex; columnIndex++) {
                        builder.append(getValue(xssfRow.getCell(columnIndex))).append(delimiter);
                    }
                    // Remove last delimiter
                    String line = builder.substring(0, builder.length() - 1);
                    list.add(line);
                }
            }
            result.put(sheetName, list);
        }
        input.close();

        return result;
    }

    public static Map<String, List<String>> readXls(InputStream input, String delimiter, int startSheetIndex,
            int endSheetIndex, int startLine, int endLine, int startColumnIndex, int endColumnIndex)
            throws IOException {
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        delimiter = (delimiter == null || "".equals(delimiter)) ? DEFAULT_DELIMITER : delimiter;
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
        int sheetCount = hssfWorkbook.getNumberOfSheets();
        if (startSheetIndex < 0 || startSheetIndex > sheetCount || startSheetIndex > endSheetIndex || startLine < 0
                || startLine > endLine || startColumnIndex < 0 || startColumnIndex > endColumnIndex) {
            System.out.println("Parameter error!");
            return result;
        }
        endSheetIndex = endSheetIndex + 1 > sheetCount ? sheetCount : endSheetIndex;

        // Read the Sheet
        for (int sheetIndex = startSheetIndex; sheetIndex <= endSheetIndex; sheetIndex++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetIndex);
            if (hssfSheet == null) {
                continue;
            }
            String sheetName = hssfSheet.getSheetName();

            List<String> list = new ArrayList<String>();
            int rowCount = hssfSheet.getLastRowNum();
            endLine = endLine > rowCount ? rowCount : endLine;
            // Read the Row
            for (int rowIndex = startLine; rowIndex <= endLine; rowIndex++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowIndex);
                if (hssfRow != null) {
                    int columnCount = hssfRow.getPhysicalNumberOfCells();
                    endColumnIndex = endColumnIndex + 1 > columnCount ? columnCount : endColumnIndex;
                    StringBuilder builder = new StringBuilder();
                    for (int columnIndex = startColumnIndex; columnIndex <= endColumnIndex; columnIndex++) {
                        builder.append(getValue(hssfRow.getCell(columnIndex))).append(delimiter);
                    }
                    // Remove last delimiter
                    String line = builder.substring(builder.length() - 1, builder.length());
                    list.add(line);
                }
            }
            result.put(sheetName, list);
        }
        input.close();
        
        return result;
    }

    @SuppressWarnings("static-access")
    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow == null) {
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
    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
