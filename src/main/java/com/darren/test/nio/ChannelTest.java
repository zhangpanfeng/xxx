package com.darren.test.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

public class ChannelTest {

    @Test
    public void test() throws IOException{
        Instant start = Instant.now();
        FileInputStream fin = new FileInputStream("C:/Users/zhda6001/Desktop/key/test.avi");
        FileOutputStream fot = new FileOutputStream("C:/Users/zhda6001/Desktop/key/test2.avi");
        FileChannel finChannel = fin.getChannel();
        FileChannel fotChannel = fot.getChannel();

        
        ByteBuffer buf = ByteBuffer.allocate(3096);
        
        while(finChannel.read(buf) != -1){
            buf.flip();
            fotChannel.write(buf);
            buf.clear();
        }
        
        finChannel.close();
        fotChannel.close();
        fin.close();
        fot.close();
        Instant end = Instant.now();
        
        System.out.println("耗时 " + Duration.between(start, end).toMillis());
    }
    
    @Test
    public void test2() throws IOException{
        Instant start = Instant.now();
        FileChannel finChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test.avi"), StandardOpenOption.READ);
        FileChannel fotChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test2.avi"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        
        finChannel.transferTo(0, finChannel.size(), fotChannel);
        Instant end = Instant.now();
        
        System.out.println("耗时 " + Duration.between(start, end).toMillis());
        finChannel.close();
        fotChannel.close();
    }

    @Test
    public void test3() throws IOException{
        Instant start = Instant.now();
        FileChannel finChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test.avi"), StandardOpenOption.READ);
        FileChannel fotChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test2.avi"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        
        ByteBuffer buf = ByteBuffer.allocateDirect(3096);
        
        while(finChannel.read(buf) != -1){
            buf.flip();
            fotChannel.write(buf);
            buf.clear();
        }
        Instant end = Instant.now();
        
        System.out.println("耗时 " + Duration.between(start, end).toMillis());
        
        finChannel.close();
        fotChannel.close();
    }
    
    @Test
    public void test4() throws IOException{
        Instant start = Instant.now();
        FileChannel finChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test.avi"), StandardOpenOption.READ);
        FileChannel fotChannel = FileChannel.open(Paths.get("C:/Users/zhda6001/Desktop/key/test2.avi"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        
        System.out.println(finChannel.size());
        int i = 0;
        for(;i < finChannel.size()-100000;){
            finChannel.transferTo(i, 100000, fotChannel);
            i = i + 100000;
        }
        finChannel.transferTo(i - 100000, finChannel.size() - i, fotChannel);
        
        Instant end = Instant.now();
        
        System.out.println("耗时 " + Duration.between(start, end).toMillis());
        finChannel.close();
        fotChannel.close();
    }
}
