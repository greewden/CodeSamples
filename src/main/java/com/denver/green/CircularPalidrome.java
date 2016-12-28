package com.denver.green;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

/**
 * Created by Denver on 12/25/2016.
 */
public class CircularPalidrome {
    public static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();
        // Start timer
        System.out.println("Starting clock");
        long tStartNS = threadMXBean.getCurrentThreadCpuTime();
        for (int i = 0; i < n; i++) {
            // Rotate string
            String current = rotate(s, i);
            System.out.println(maxPalindromeLen(current));
        }
        // End timer
        long tEndNS = threadMXBean.getCurrentThreadCpuTime();
        System.out.println("Clock stopped");
        System.out.println(String.format("Total CPU time : %.6f sec", (float)(tEndNS - tStartNS) / 1.0e9));
    }

    /**
     * Performs a k character rotation on the string s, by cutting the first k
     * characters from the beginning of s and appending them to the end of s.
     * @param s - the String on which the rotation is to be done.
     * @param k - an integer representing the number of characters to rotate.
     * @return rotated string.
     */
    public static String rotate(String s, int k) {
        if (k == 0) {
            return s;
        }
        k = k % s.length();
        StringBuilder rotated = new StringBuilder(s.substring(k));
        rotated.append(s.substring(0, k));
        return rotated.toString();
    }

    /**
     * Determines if the supplied string is a palindrome, a string that reads
     * the same from left to right as it does from right to left.
     * @param s - string to check for being a palindrom
     * @return true if string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
        // Create a reversed version of string s
        // String reverse = new StringBuilder(s).reverse().toString();
        // return s.equals(reverse);
    }

    public static int maxPalindromeLen(String s) {
        if (s == null || s == "") {
            return 0;
        }
        // Create a window that is initially as large as the input string.
        int winSize = s.length();
        boolean foundPalindrome = false;
        while (true) {
            // Place window at start of string and slide it along the string
            // until a palindrome is found or the end of the string is reached.
            int start = 0;
            int end = winSize;
            while (end <= s.length()) {
                String subString = s.substring(start, end);
                foundPalindrome = isPalindrome(subString);
                if (foundPalindrome) {
                   return winSize;
                }
                end++;
                start++;
            }

            // Decrease window size as no palindrome was found that fit the window.
            winSize--;
        }
    }
}
