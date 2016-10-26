package com.darren.test.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteThread {
    public static void main(String[] args) {
        File file = new File("e://a.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriteThread fileWriteThread = new FileWriteThread();
        FThread f1 = fileWriteThread.new FThread(bw);
        for(int i = 0; i < 100; i++){
            Thread t = new Thread(f1, "thread" + i);
            t.start();
        }
    }

    class FThread implements Runnable {

        private BufferedWriter bw;

        public FThread(BufferedWriter bw) {
            this.bw = bw;
        }

        @Override
        public void run() {
            try {
                bw.write(Thread.currentThread().getName() + ":aaaaaaaaa");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
