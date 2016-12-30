package com.denver.green;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

/**
 * Created by Denver on 12/25/2016.
 */
public class CircularPalidrome {
    private static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        in.close();
        StringBuilder lengths = new StringBuilder(n * 2);

        // Start timer
        System.out.println("Starting clock");
        long tStartNS = threadMXBean.getCurrentThreadCpuTime();
        for (int i = 0; i < n; i++) {
            // Rotate String
            String current = rotate(s, i);
            lengths.append(longestPalindrome(current));
            lengths.append("\n");
        }
        // End timer
        long tEndNS = threadMXBean.getCurrentThreadCpuTime();
        System.out.println(lengths);
        System.out.println("Clock stopped");
        System.out.println(String.format("Total CPU time : %.6f sec", (float)(tEndNS - tStartNS) / 1.0e9));
    }

    /**
     * Performs a k character rotation on the String s, by cutting the first k
     * characters from the beginning of s and appending them to the end of s.
     * @param s - the String on which the rotation is to be done.
     * @param k - an integer representing the number of characters to rotate.
     * @return rotated String.
     */
    static String rotate(String s, int k) {
        if (k == 0) {
            return s;
        }
        k = k % s.length();
        return s.substring(k).concat(s.substring(0, k));
    }

    /**
     * Finds the length of the longest palindrome centered on the indexes c1 and c2. If c1 == c2
     * then the palindromes found will be of odd length and if c1 != c2 then the palindromes found
     * will be of even length.
     * @param s - string to be searched
     * @param c1 - index of the character to the immediate left of the center point.
     * @param c2 - index of the character to the immediate right of the center point.
     * @return an integer which represents the length of the longest palindrom found centered
     *         on the point indicated.
     */
     static int expandAroundCenter(String s, int c1, int c2) {
        if (s == null || s.equals("")) return 0;
        int n = s.length();
        if (n == 1) return 1;

        int max = 0;

        for (int left = c1, right = c2; left >= 0 && right < n; left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                return max;
            }
            max += 2;
        }
        return max;
    }

    /**
     * Finds the length of the longest palindrome in the string s.
     * @param s - string to be searched.
     * @return an integer representing the length of the longest palindrome found in the string s.
     */
    static int longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) return 0;
        int longest = 0;  // a single char itself is a palindrome
        // Walk the center point used for finding palindromes along the string being searched.
        for (int i = 0; i < n-1; i++) {
            // Look for odd length palindromes centered on i.
            int oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome > longest) {
                longest = oddPalindrome - 1;
            }

            // Look for even length palindromes centered in the gap between i and i+1
            int evenPalindrome = expandAroundCenter(s, i, i+1);
            if (evenPalindrome > longest) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }
}
