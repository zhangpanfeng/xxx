package com.darren.test.util;

public class StringUtil {

    /**
     * check if the source is empty
     * 
     * @param source
     * @return null or "" True, otherwise False
     */
    public static boolean isEmpty(String source) {
        if (source == null || "".equals(source)) {
            return true;
        } else {
            return false;
        }
    }
}
