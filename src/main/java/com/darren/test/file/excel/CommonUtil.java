package com.darren.test.file.excel;

public class CommonUtil {
    
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String LIB_PATH = "lib";
    public static final String STUDENT_INFO_XLS_PATH = LIB_PATH + "/student_info" + POINT + OFFICE_EXCEL_2003_POSTFIX;
    public static final String STUDENT_INFO_XLSX_PATH = LIB_PATH + "/student_info" + POINT + OFFICE_EXCEL_2010_POSTFIX;
    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";

    
    /**
     * get postfix of the path
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || CommonUtil.EMPTY.equals(path.trim())) {
            return CommonUtil.EMPTY;
        }
        if (path.contains(CommonUtil.POINT)) {
            return path.substring(path.lastIndexOf(CommonUtil.POINT) + 1, path.length());
        }
        return CommonUtil.EMPTY;
    }
}
