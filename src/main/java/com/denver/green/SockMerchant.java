package com.denver.green;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Denver on 12/21/2016.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/25168-sock-merchant-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482343299&Signature=6RbllNvcxOWLJSYiXyKx45Vr9CQ%3D&response-content-disposition=inline%3B%20filename%3Dsock-merchant-English.pdf&response-content-type=application%2Fpdf
 */
public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        in.close();

        int count = countMatching(c);
        System.out.println(count);
    }

    public static int countMatching(int[] input) {
        if (input.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> matched = new HashMap<>(input.length / 2);

        for (int item : input) {
            matched.put(item, matched.getOrDefault(item, 0) + 1);
        }

        int total = 0;
        for (int count : matched.values()) {
            total += count / 2;
        }
        return total;
    }
}
