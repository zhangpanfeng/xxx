package com.darren.test.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesTest {
    private static String FILE_KEY = "test.output.properties";

    private static void setUp() {
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\test.properties";
        System.setProperty(FILE_KEY, filePath);
    }

    private static void save(String key, String value) throws IOException {
        File file = new File(System.getProperty(FILE_KEY));
        Properties properties = new Properties();
        properties.setProperty(key, value);
        OutputStream os = new FileOutputStream(file);
        properties.store(os, "Save key: " + key + " value: " + value + "");
        os.close();
    }

    private static String get(String key) throws IOException {
        Properties properties = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(System.getProperty(FILE_KEY)));
        properties.load(in); /// 加载属性列表
        return properties.getProperty(key);
    }

    public static void main(String[] args) throws IOException {
        setUp();
        save("key", "value");
        save("key1", "value1");
        save("key2", "value2");
        System.out.println(get("key"));
    }

}
