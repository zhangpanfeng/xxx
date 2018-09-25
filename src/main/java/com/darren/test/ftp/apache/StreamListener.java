package com.darren.test.ftp.apache;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;

public class StreamListener implements CopyStreamListener {
    private static final NumberFormat FORMATER = new DecimalFormat("#.##");
    private long totalSize;

    public StreamListener(long totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public void bytesTransferred(CopyStreamEvent event) {
        System.out.println("==");
    }

    @Override
    public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
        // System.out.println("上传 " + totalBytesTransferred * 100.0 / totalSize + " %");
        System.out.println("上传 " + FORMATER.format(totalBytesTransferred * 100.0 / totalSize) + " %");
    }

}
