package com.denver.green;
/*
Arrays: Left Rotation
https://hackerrank-challenge-pdfs.s3.amazonaws.com/24100-ctci-array-left-rotation-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1481152792&Signature=ld9nzsUr247j21AZwW2zb93JgIM%3D&response-content-disposition=inline%3B%20filename%3Dctci-array-left-rotation-English.pdf&response-content-type=application%2Fpdf
 */

import java.util.Scanner;

public class ArrayLeftRotation {

    static int[] arrayLeftRotation(int[] source, int numberOfElements, int numberOfRotations) {
        int[] result = new int[numberOfElements];
        // Set number of rotations to the remainder of number of rotations / number of elements
        // this will cover the case where rotations is greater than the number of elements in the
        // array.
        numberOfRotations = numberOfRotations % numberOfElements;
        int totalElementsToRotate = numberOfElements - numberOfRotations;
        System.arraycopy(source, numberOfRotations, result, 0,totalElementsToRotate);
        System.arraycopy(source, 0, result, totalElementsToRotate, numberOfRotations);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
        int numberOfRotations = in.nextInt();
        int a[] = new int[numberOfElements];
        for(int i=0; i < numberOfElements; i++){
            a[i] = in.nextInt();
        }

        int[] output;
        output = arrayLeftRotation(a, numberOfElements, numberOfRotations);
        for(int i = 0; i < numberOfElements; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }
}