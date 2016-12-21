package com.denver.green;

import java.util.Scanner;

/**
 * Created by degreen on 2016-12-19.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/19001-30-binary-numbers-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482240480&Signature=w5exdtWTmkmQbvty%2BYSQIUS4wm4%3D&response-content-disposition=inline%3B%20filename%3D30-binary-numbers-English.pdf&response-content-type=application%2Fpdf
 *
 */
public class ConsecutiveBinaryDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        System.out.println(countConsecutiveOnes(num));
    }

    public static int countConsecutiveOnes(int n) {
        // Convert decimal number to a binary string.
        String binStr = Integer.toBinaryString(n);
        int count = 0, maxCount = 0;
        // Iterate through the binary representation of the provided number and determine the length
        // of each grouping of consecutive ones. Save the size of the largest grouping of ones
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '0') {
                // Encountered a zero reset ones counter to zero.
                count = 0;
            } else {
                // Increment ones count.
                count++;
            }
            // Update max count if necessary.
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
