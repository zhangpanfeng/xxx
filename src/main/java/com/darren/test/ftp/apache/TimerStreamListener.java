package com.darren.test.ftp.apache;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;

public class TimerStreamListener extends TimerTask implements CopyStreamListener {
    private static final NumberFormat FORMATER = new DecimalFormat("#.##");
    private long totalSize;
    private long totalBytesTransferred;
    private Timer timer;

    public TimerStreamListener(long totalSize) {
        this.totalSize = totalSize;
        this.timer = new Timer();
        this.timer.schedule(this, 5, 30);
    }

    @Override
    public void bytesTransferred(CopyStreamEvent event) {
        System.out.println("==");
    }

    @Override
    public void bytesTransferred(long totalBytesTransferred, int bytesTransferred, long streamSize) {
        this.totalBytesTransferred = totalBytesTransferred;
        if(this.totalBytesTransferred == this.totalSize){
            this.timer.cancel();
            this.print();
        }
    }

    @Override
    public void run() {
//        while(this.totalBytesTransferred < this.totalSize){
//            
//        }
//        this.timer.cancel();
        this.print();
    }

    private void print(){
     // System.out.println("上传 " + totalBytesTransferred * 100.0 / totalSize + " %");
        System.out.println("上传 " + FORMATER.format(totalBytesTransferred * 100.0 / totalSize) + " %");
    }
}
