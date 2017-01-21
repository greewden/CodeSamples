package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/13/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/24060-bon-appetit-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1484336303&Signature=PdSDq6lT9fkv2Rv9C3bZYKf6Vuo%3D&response-content-disposition=inline%3B%20filename%3Dbon-appetit-English.pdf&response-content-type=application%2Fpdf
 */
public class BonAppetit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numItems = in.nextInt();
        int itemNotEaten = in.nextInt();
        int[] costs = new int[numItems];

        for (int i = 0; i < numItems; i++) {
            costs[i] = in.nextInt();
        }
        int amountCharged = in.nextInt();
        int amountOwed = calcAmtOwed(costs, itemNotEaten);
        System.out.println(validateAmountCharged(amountCharged, amountOwed));
    }

    public static int calcAmtOwed(int[] costs, int itemNotEaten) {
        int sharedTotal = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i == itemNotEaten) {
                continue;
            }
            sharedTotal += costs[i];
        }
        return sharedTotal / 2;
    }

    public static String validateAmountCharged(int amountCharged, int amountOwed) {
        if (amountCharged == amountOwed) {
            return "Bon Appetit";
        } else {
            int amountRefund = amountCharged - amountOwed;
            return Integer.toString(amountRefund);
        }
    }
}
