package com.denver.green;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denver on 1/8/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/26276-mini-max-sum-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1484331645&Signature=HYXtZBlhFsKVtAEA8QoRGIZBDpI%3D&response-content-disposition=inline%3B%20filename%3Dmini-max-sum-English.pdf&response-content-type=application%2Fpdf
 */
public class MinMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> numbers = new ArrayList<Long>(5);
        numbers.add(in.nextLong());
        numbers.add(in.nextLong());
        numbers.add(in.nextLong());
        numbers.add(in.nextLong());
        numbers.add(in.nextLong());
        numbers.sort(null);
        long partialSum = numbers.get(1) + numbers.get(2) + numbers.get(3);
        long minSum = partialSum + numbers.get(0);
        long maxSum = partialSum + numbers.get(4);
        System.out.println(minSum + " " + maxSum);
    }

}
