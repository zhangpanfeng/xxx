package com.darren.test.ftp.apache;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FTPTest {

    @Test
    public void test() throws SocketException, IOException{
        FTPUtil ftp = new FTPUtil();
        ftp.connectFTP("10.227.6.62", 21, "darrenftp", "darrenftp");
        Map<String, String> files = new HashMap<>();
        files.put("C:/Users/zhda6001/Desktop/key/test.avi", "xxx.avi");
        ftp.upload(files);
        ftp.close();
    }
    
    @Test
    public void test2() throws SocketException, IOException{
        FTPUtil ftp = new FTPUtil();
        ftp.connectFTP("10.227.6.62", 21, "darrenftp", "darrenftp");
        ftp.download();
        ftp.close();
    }
}
