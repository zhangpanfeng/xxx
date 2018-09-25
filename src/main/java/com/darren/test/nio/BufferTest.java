package com.darren.test.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

public class BufferTest {

    @Test
    public void test(){
        //1、通过allocate分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        
        System.out.println("=============allocate()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        
        //2、存储数据
        String value = "darren";
        buf.put(value.getBytes());
        
        
        System.out.println("=============put()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        
        buf.flip();
        System.out.println("=============flip()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        
        //byte[] dst = new byte[buf.limit()];
        byte cr = buf.get();
        System.out.println(cr);
        System.out.println("=============get()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        
        //重复读
        buf.rewind();
        System.out.println("=============rewind()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        
        //清空缓冲区
        buf.clear();
        System.out.println("=============clear()====================");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
    }
}
