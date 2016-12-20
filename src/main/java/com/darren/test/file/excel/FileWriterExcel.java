package com.darren.test.file.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileWriterExcel {

    public void writeXlsx(String path, List<ExcelEntity> entityList)throws IOException{
        System.out.println(CommonUtil.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        ExcelEntity excelEntity = null;
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        for(ExcelEntity entity: entityList){
            
            int fieldLength = entity.getFieldLength();
            for(int i = 0; i < fieldLength; i++){
                
            }
        }
    }
}
