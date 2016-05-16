package com.snmill.cp;

/**
 *
 */
public class PrintHalfMillion {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            sb.append('A');
        }
        System.out.println(sb);
    }

}
