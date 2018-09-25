package com.darren.test.jsch;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

public class SFTPTest {

    @Test
    public void test() throws JSchException, SftpException {
        JSCHUtil jsch = new JSCHUtil();
        Map<String, String> option = new HashMap<String, String>();
        option.put("host", "10.227.6.62");
        option.put("port", "22");
        option.put("username", "darren");
        option.put("password", "darren");
        jsch.getChannel(option, new Properties(), 1000);

        Map<String, String> files = new HashMap<String, String>();
        files.put("C:/Users/zhda6001/Desktop/key/test.avi", "/home/darren/test/");
        
        ProgressMonitor monitor = new ProgressMonitor();
        jsch.upload(files, monitor, ChannelSftp.OVERWRITE);

        jsch.closeChannel();
    }
}
