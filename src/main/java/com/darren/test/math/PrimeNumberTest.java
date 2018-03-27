package com.darren.test.math;

public class PrimeNumberTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //generatePrimeNumber(1, 100);
        //generatePrimeNumber(100, 200);
        
        generatePrimeNumber1(1, 100);
    }

    public static void generatePrimeNumber(int start, int end) {
        for(int i = start; i <= end; i++) {
            int j = 0;
            int k = (int) Math.sqrt(i);
            for( j = 2; j <= k; j++) {
                if(i % j == 0) {
                    break;
                }
            }
            
            if(j > k) {
                System.out.println(i);
            }
        }
    }
    //ERROR
    public static void generatePrimeNumber1(int start, int end) {
        int length = end - start + 1;
        int[] value = new int[length];
        if(start <= 1) {
            start = 3;
        }
        
        for(int i = start; i <= end; i++) {
            for(int j = 2; j < length/2; j++) {
                if(i <= j && j % i == 0) {
                    value[i - start] = 1;
                }
//                else{
//                    value[i - start] = 1;
//                }
            }
        }
        
        for(int k = start; k <= end; k++) {
            if(value[k-start] == 0) {
                System.out.println(k);
            }
        }
    }
}
