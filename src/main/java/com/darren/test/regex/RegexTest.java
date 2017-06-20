package com.darren.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

//    public static void main(String[] args) {
//        String s = "FEMALE_01_19_";
//        Pattern pattern = Pattern.compile("^(MALE|FEMALE)_(\\d+)_(\\d+)");
//        Matcher matcher = pattern.matcher(s);
//        while(matcher.find()) {
//            System.out.println(matcher.group(0));
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//            s = s.replaceAll(matcher.group(2), Integer.valueOf(matcher.group(2)).toString());
//        }
//        boolean result = matcher.matches();
//        System.out.println(result);
//        System.out.println(s);
//    }

    
    public static void main(String[] args) {  
        //String regEx = "[<|<\\/]HashMap>";  
        String regEx = "</HashMap>|<HashMap>";  
        String source = "<HashMap><token>VDfcWIdVcPQF6NzZHE+lny5APylkjuanHIVtM4CKWOmIz3M2lfmvo5MsPo5Y3E2B3gV6YOLgKNntcCQDmX9Ys1/xM42szcrIgrtDjNKymXioeEr11MHvlzC743IvSV23JOAOtGQGJ4x1rEfUTmjghBRZyI0XI66aafIQTHgV534h9bRrYWuxb68vzn/+ph50KlO2BFucUA8z43CPJTLG8emTe0EjCdqFJj74cpqFb6y0rC5e7B0VJmXHiIgjqMtxZ2nU3XWiMIDIFtnsz+Q0/N1YVlLkce1YzMqdpMFP5wXAwzoOYMkKFnO1iWN4obBvkZuBwtUV8lIDwE6nYW+xxQ==</token></HashMap>";  
        Pattern pattern = Pattern.compile(regEx);  
        Matcher matcher = pattern.matcher(source);  
      String result =  source.replaceAll(regEx, "");
      System.out.println(result);
//        while (matcher.find()) {  
//            String result = matcher.group(0);  
//            System.out.println(result);  
//        }  
    }  
}
