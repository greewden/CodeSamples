package com.denver.green;

/**
 * Created by Denver on 12/18/2016.
 *
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/24548-repeated-string-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482127483&Signature=95V2cu9tJ5Tmd4rOTYCXm2pp7eA%3D&response-content-disposition=inline%3B%20filename%3Drepeated-string-English.pdf&response-content-type=application%2Fpdf
 */

import java.util.Scanner;

public class CharacterCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        in.close();
    }

    public static long countChar(String s, long n, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }

        long numOfReps = n / s.length();
        long charCount = count * numOfReps;
        count = 0;
        long remainder = n % s.length();
        for (int i = 0; i < remainder; i++){
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return charCount + count;
    }
}
