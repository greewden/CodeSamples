package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/2/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/19055-30-sorting-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1483415172&Signature=82cGCFWrwKa3aUq324H%2FfJXex0Y%3D&response-content-disposition=inline%3B%20filename%3D30-sorting-English.pdf&response-content-type=application%2Fpdf
 */
public class BubbleSort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numElems = in.nextInt();
        int[] a = new int[numElems];
        for (int i = 0; i < numElems; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        bubbleSort(a);
    }

    private static void printArray(String s, int[] x) {
        System.out.print(s + " Array: ");
        for(int i : x){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] x) {
        int endPosition = x.length - 1;
        int swapPosition;
        int swapTotal = 0;

        while( endPosition > 0 ) {
            int numOfSwaps = 0;
            swapPosition = 0;
            for(int i = 0; i < endPosition; i++) {
                if( x[i] > x[i + 1] ){
                    // Swap elements 'i' and 'i + 1':
                    int tmp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = tmp;

                    swapPosition = i;
                    numOfSwaps++;
                }
            }
            endPosition = swapPosition;
            // If no elements were swapped during a traversal, array is sorted.
            if (numOfSwaps == 0) {
                break;
            }
            swapTotal += numOfSwaps;
        }
        System.out.printf("Array is sorted in %d swaps.\n", swapTotal);
        System.out.printf("First Element: %d\n", x[0]);
        System.out.printf("Last Element: %d\n", x[x.length - 1]);
    } // end bubbleSort
}
