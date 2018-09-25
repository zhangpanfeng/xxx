package com.darren.test.ftp.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class FTPUtil {

    private Socket ftp;
    private BufferedReader reader;
    private BufferedWriter writer;
    private StringBuffer commandBuffer;
    private static final String COMMAND_DELIMITER = " ";
    private static final String COMMAND_SUFFIX = "\r\n";

    public FTPUtil() {

    }

    public void connectFTP(String host, int port, String userName, String password)
            throws UnknownHostException, IOException {
        this.ftp = new Socket(host, port);
        this.reader = new BufferedReader(new InputStreamReader(ftp.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(ftp.getOutputStream()));
        this.commandBuffer = new StringBuffer();
        System.out.println(this.reader.readLine());
        // 登录
        this.sendCommand(Command.USER, userName);
        System.out.println(this.reader.readLine());

        this.sendCommand(Command.PASS, password);
        System.out.println(this.reader.readLine());
    }

    private void sendCommand(Command command) throws IOException {
        this.sendCommand(command, "");
    }

    private void sendCommand(Command command, String arg) throws IOException {
        this.commandBuffer.setLength(0);
        this.commandBuffer.append(command.toString()).append(COMMAND_DELIMITER);
        this.commandBuffer.append(arg).append(COMMAND_SUFFIX);
        writer.write(this.commandBuffer.toString());
        writer.flush();
    }

    public void upload(String localPath, String remotePath) throws IOException {
        // 进入被动模式
        this.sendCommand(Command.PASV);
        String response = reader.readLine();
        if (!response.startsWith("227")) {
            throw new IOException("SimpleFTP could not request passive mode: " + response);
        }

        int startIndex = response.indexOf("(");
        int endIndex = response.indexOf(")");
        StringTokenizer tokenizer = new StringTokenizer(response.substring(startIndex + 1, endIndex), ",");
        String ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
                + tokenizer.nextToken();
        int port = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());

        System.out.println(ip + "  " + port);

        // 上传文件前的准备
        File localFile = new File(localPath);
        InputStream inputStream = new FileInputStream(localFile);
        //this.sendCommand(Command.STOR, localFile.getName());
        //System.out.println(this.reader.readLine());

        Socket dataSocket = new Socket(ip, port);
        BufferedReader reader = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
        //System.out.println(reader.readLine());

        // 上传文件
        int offset;
        byte[] bytes = new byte[1024];
        while ((offset = inputStream.read(bytes)) != -1) {
            dataSocket.getOutputStream().write(bytes, 0, offset);
        }

        System.out.println("upload success!!");

        // 上传文件后的善后工作
        dataSocket.getOutputStream().close();
        reader.close();
        inputStream.close();
        dataSocket.close();
    }

    public void disconnectFTP() throws IOException {
        this.reader.close();
        this.writer.close();
        ftp.close();
    }
}
