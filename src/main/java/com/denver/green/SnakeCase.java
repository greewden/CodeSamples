package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 12/21/2016.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/29375-snake-case-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482371350&Signature=O6J0D8KckFi%2B0yQiolvm4LmM%2FAE%3D&response-content-disposition=inline%3B%20filename%3Dsnake-case-English.pdf&response-content-type=application%2Fpdf
 */
public class SnakeCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        System.out.println(countWords(s));
    }

    public static int countWords(String input) {
        if (input == null || input.length() == 0) return 0;
        String[] results = input.split("_");
        return results.length;
    }
}
