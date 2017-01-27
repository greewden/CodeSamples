package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/26/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/1716-coin-change-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1485484863&Signature=DZQ8OiosDgllc%2BuEVp0p3tNGLUU%3D&response-content-disposition=inline%3B%20filename%3Dcoin-change-English.pdf&response-content-type=application%2Fpdf
 *
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int toChange = in.nextInt();           // Amount to obtain change for.
        int availableDenominations = in.nextInt(); // Number of distinct coin denominations.
        int[] distinctDenominations = new int[availableDenominations];  // Available denominations for making change.
        for (int i = 0; i < availableDenominations; i++) {
            distinctDenominations[i] = in.nextInt();
        }
        System.out.println(makeChange(distinctDenominations, availableDenominations, toChange));
    }

    public static int makeChange(int[] denominations, int availDenom, int amtToChange) {
        // If amtToChange equals zero then there is only 1 solution which is no change.
        if (amtToChange == 0) {
            return 1;
        }

        // If amtToChange is less than zero then there is no solution.
        if (amtToChange < 0) {
            return 0;
        }

        // If there is no available denominations and the amount to change is
        // greater than zero then there are no solutions.
        if (availDenom == 0 && amtToChange > 0) {
            return 0;
        }

        // Recursively calculate the number of ways to make change. The number of ways is the sum of:
        // 1) The number of ways to make change with a distinct denomination. (Soln includes the availDenom-1 coin)
        // 2) The number of wayts to make change without a distinct denomination. (Sol'n excludes the availDenom-1 coin)
        return makeChange(denominations, availDenom, amtToChange - denominations[availDenom - 1]) +
                makeChange(denominations, availDenom - 1, amtToChange);
    }
}
