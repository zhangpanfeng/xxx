package com.darren.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String s = "FEMALE_01_19_";
        Pattern pattern = Pattern.compile("^(MALE|FEMALE)_(\\d+)_(\\d+)");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            s = s.replaceAll(matcher.group(2), Integer.valueOf(matcher.group(2)).toString());
        }
        boolean result = matcher.matches();
        System.out.println(result);
        System.out.println(s);
    }

}
