package com.darren.test.file.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    private BufferedWriter bw = null;

    public FileWriter(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            bw = new BufferedWriter(new java.io.FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String context) {
        try {
            bw.write(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void newLine(){
        try {
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
