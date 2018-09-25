package com.darren.test.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import org.junit.Test;

public class BlockChannelTest {

    @Test
    public void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));

        ByteBuffer buf = ByteBuffer.allocate(1024);
        // Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer buffer = new StringBuffer();
        // while (scanner.hasNext()) {
        // buf.put(URLEncoder.encode(scanner.next(), "UTF-8").getBytes());
        // buf.flip();
        // sChannel.write(buf);
        // buf.clear();
        // }

        new Thread(new Receiver(sChannel)).start();

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println("\t\t\t\t\tClient say: " + line);
            buf.put(line.getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();

            if ("STOP".equalsIgnoreCase(line)) {
                break;
            }
        }

        // sChannel.close();
    }

    @Test
    public void server() throws IOException {
        int clientCount = 0;
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.bind(new InetSocketAddress(8000));

        while(true){
            SocketChannel sChannel = ssChannel.accept();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            int len;
            while ((len = sChannel.read(buf)) != -1) {
                buf.flip();
                String message = new String(buf.array(), 0, len);
                if ("STOP".equalsIgnoreCase(message)) {
                    
                }
                // System.out.println("Client Say: " + message);
                buf.clear();
                buf.put(message.getBytes());
                buf.flip();
                sChannel.write(buf);
                buf.clear();

            }
            
            sChannel.close();
            clientCount++;
            System.out.println("============= " + clientCount);
            if(clientCount == 3){
                break;
            }
        }

        ssChannel.close();
    }
}
