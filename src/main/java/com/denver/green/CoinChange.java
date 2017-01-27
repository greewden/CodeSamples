package com.denver.green;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Denver on 1/26/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/1716-coin-change-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1485484863&Signature=DZQ8OiosDgllc%2BuEVp0p3tNGLUU%3D&response-content-disposition=inline%3B%20filename%3Dcoin-change-English.pdf&response-content-type=application%2Fpdf
 *
 */
public class CoinChange {

    private int [][] storedSolns;
    private int [] denominations;
    private int amount;

    public CoinChange(int[] denominations, int amount) {
        this.denominations = denominations;
        this.amount = amount;

        // Fill table used for remembering previous solutions with -1
        // this is a 2 dimensional table with the first dimension representing
        // the amount to be changed and the second dimension representing
        // the number of distinct denominations available for making change.
        this.storedSolns = new int[amount + 1] [denominations.length];
        for (int i = 0; i <= amount; i++){
            Arrays.fill(storedSolns[i], -1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int toChange = in.nextInt();           // Amount to obtain change for.
        int availableDenominations = in.nextInt(); // Number of distinct coin denominations.
        int[] distinctDenominations = new int[availableDenominations];  // Available denominations for making change.
        for (int i = 0; i < availableDenominations; i++) {
            distinctDenominations[i] = in.nextInt();
        }
        CoinChange change = new CoinChange(distinctDenominations, toChange);
        System.out.println(change.makeChange(availableDenominations, toChange));
    }

    public int makeChange(int availDenom, int amtToChange) {
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

        // Calculate the number of ways to make change. The number of ways is the sum of:
        // 1) The number of ways to make change with a distinct denomination. (Soln includes the availDenom-1 coin)
        //    first check to see if the answer is already stored in the storedSolns table, if not then recursively
        //    calculate it.
        int withDistinctDenom;
        int newAmt = amtToChange - denominations[availDenom - 1];
        if (newAmt >= 0 && storedSolns[newAmt][availDenom - 1] != -1) {
            withDistinctDenom = storedSolns[newAmt][availDenom - 1];
        } else {
            withDistinctDenom = makeChange(availDenom, newAmt);
        }

        // 2) The number of wayts to make change without a distinct denomination. (Sol'n excludes the availDenom-1 coin)
        int withoutDistinctDenom;
        if (storedSolns[amtToChange][availDenom - 1] != -1) {
            withoutDistinctDenom = storedSolns[amtToChange][availDenom - 1];
        } else {
            withoutDistinctDenom = makeChange(availDenom - 1, amtToChange);
        }
        return  withDistinctDenom + withoutDistinctDenom;
    }
}
