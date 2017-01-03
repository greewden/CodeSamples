package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 12/21/2016.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/22578-camelcase-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482342102&Signature=dwWdV96GpLeJWNMxOUGVPKtAV80%3D&response-content-disposition=inline%3B%20filename%3Dcamelcase-English.pdf&response-content-type=application%2Fpdf
 *
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int wordCount = countWords(s);
        System.out.println(wordCount);
        in.close();
    }

    public static int countWords(String s) {
        if (s == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) count++;
        }
        return count;
    }
}
