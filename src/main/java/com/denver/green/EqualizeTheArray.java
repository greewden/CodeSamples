package com.denver.green;
/**
 * Created by Denver on 12/16/2016.
 *
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/21555-equality-in-a-array-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1481916029&Signature=Chy3on6bWpLSPeflV8sl8QB%2FMxE%3D&response-content-disposition=inline%3B%20filename%3Dequality-in-a-array-English.pdf&response-content-type=application%2Fpdf
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualizeTheArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Get number of elements to place in the array.
        int numElems = in.nextInt();
        int[] a = new int[numElems];
        for (int i = 0; i < numElems; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(calcNumOfDeletions(a));
    }

    static public int calcNumOfDeletions(int[] a) {
        // Scan through array and count the number of times each value occurs, add the count to a hash map
        // keyed on the value also update maxCount if count is larger than it.
        Map<Integer, Integer> counts = new HashMap<>(a.length);
        int maxCount = 0;
        for (int value : a) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
            if (counts.get(value) > maxCount) {
                maxCount = counts.get(value);
            }
        }
        // Calculate the minimum number of deletions needed to make all elements in the array the same.
        return a.length - maxCount;
    }
}
