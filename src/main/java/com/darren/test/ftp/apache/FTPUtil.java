package com.darren.test.ftp.apache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPUtil {

    private FTPClient ftp;

    public FTPUtil() {

    }

    public FTPClient connectFTP(String host, int port, String username, String password)
            throws SocketException, IOException {
        // 创建ftp
        ftp = new FTPClient();
        // 连接
        ftp.connect(host, port);
        // 登陆
        boolean result = ftp.login(username, password);
        System.out.println("是否login成功： " + result);

        ftp.changeWorkingDirectory("/home/darrenftp/ftp/test");
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftp.setControlEncoding("UTF-8");

        return ftp;
    }

    public void upload(Map<String, String> files) throws IOException {
        if (files == null) {
            return;
        }

        Set<String> keySet = files.keySet();
        for (String localFile : keySet) {
            String remoteFile = files.get(localFile);

            InputStream input = new FileInputStream(localFile);
            ftp.setCopyStreamListener(new TimerStreamListener(input.available()));
            // ftp.setCopyStreamListener(new StreamListener(input.available()));
            boolean result = ftp.storeFile(remoteFile, input);

            System.out.println("是否upload成功： " + result);

            input.close();
        }
    }

    public void download() throws IOException {
        FTPFile[] files = ftp.listFiles();
        for (FTPFile remoteFile : files) {
            File localFile = new File("C:/Users/zhda6001/Desktop/key/" + remoteFile.getName());
            OutputStream is = new FileOutputStream(localFile);
            boolean result = ftp.retrieveFile(remoteFile.getName(), is);
            System.out.println("是否download成功： " + result);
            is.close();
        }
    }

    public void close() throws IOException {
        ftp.logout();
        if (ftp.isConnected()) {
            try {
                ftp.disconnect();
            } catch (IOException ioe) {
            }
        }
    }
}
