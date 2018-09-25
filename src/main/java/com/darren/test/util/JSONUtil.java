package com.darren.test.util;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

public class JSONUtil {

    public static void outputObject(OutputStream os, Object obj, Type typeofSrc) {
        JsonWriter writer = null;
        try {
            writer = new JsonWriter(new OutputStreamWriter(os, "UTF-8"));
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            gson.toJson(obj, typeofSrc, writer);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {

                } finally {
                    writer = null;
                }
            }
        }
    }

    public static String toString(Object obj, Type typeofSrc) {
        try {
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            return gson.toJson(obj, typeofSrc);
        } catch (Exception e) {
            System.err.println("error when parse response:" + obj + e);
            return null;
        }
    }

    public static Object fromJson(String jsonStr, Type typeofSrc) {
        try {
            return new Gson().fromJson(jsonStr, typeofSrc);
        } catch (Exception e) {
            System.err.println("error when parse jsonStr:" + jsonStr + e);
            return null;
        }
    }

    public static String toJsonString(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String value = null;
        try {
            value = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return value;
    }

    public static <T> T toJavaObject(String source, TypeReference<T> valueTypeRef) {
        ObjectMapper mapper = new ObjectMapper();
        T value = null;
        try {
            value = mapper.readValue(source, valueTypeRef);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return value;
    }
}
