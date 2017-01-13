package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/13/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/16032-mars-exploration-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1484330097&Signature=netQ06dycGVFJDvbt2cxod6hjk4%3D&response-content-disposition=inline%3B%20filename%3Dmars-exploration-English.pdf&response-content-type=application%2Fpdf
 */
public class MarsExploration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(numLettersAltered("SOS", s));
    }

    /**
     * Takes a message and a character sequence that is used to generate the message.
     * The original contents of the message has been altered by cosmic radiation during
     * transmission and this function will return the number of letters altered by the
     * radiation in the received message.
     * @param base - sequence of characters used to create the message.
     * @param message - message received after being altered by cosmic radiation.
     * @return number of letters altered in the received message.
     */
    public static int numLettersAltered(String base, String message) {
        int baseLen = base.length();
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != base.charAt(i % baseLen)) {
                count++;
            }
        }
        return count;
    }
}
