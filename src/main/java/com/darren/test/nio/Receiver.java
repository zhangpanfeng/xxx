package com.darren.test.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Receiver implements Runnable {

    private SocketChannel channel;

    public Receiver(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        try {
            int len;
            while((len = channel.read(buf)) != -1){
                buf.flip();
                String message = new String(buf.array(), 0, len);
                System.out.println("\t\t\t\t\t\t\t\tServer say: " + message);
                buf.clear();

                if("STOP".equalsIgnoreCase(message)){
                    break;
                }
            }
//            channel.close();
            channel.shutdownOutput();
            channel.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

}
