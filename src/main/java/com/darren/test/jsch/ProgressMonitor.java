package com.darren.test.jsch;

import java.io.File;
import java.text.DecimalFormat;

import com.jcraft.jsch.SftpProgressMonitor;

public class ProgressMonitor implements SftpProgressMonitor{
    private long transfered;
    private long totalSize;
    
    @Override
    public void init(int op, String src, String dest, long max) {
        System.out.println("Transferring begin.");
        File file = new File(src);
        totalSize = file.length();
    }

    @Override
    public boolean count(long count) {
        transfered = transfered + count;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Currently transferred percent: " + df.format(100.0 * transfered /totalSize) + " %");
        return true;
    }

    @Override
    public void end() {
        System.out.println("Transferring done.");
    }

}
