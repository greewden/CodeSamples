package com.denver.green;

import java.util.Scanner;

/**
 * Created by degreen on 2016-12-20.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/17164-30-2d-arrays-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1482303405&Signature=%2FOV5jmim5YxUQaYHHUG7e2tgKtA%3D&response-content-disposition=inline%3B%20filename%3D30-2d-arrays-English.pdf&response-content-type=application%2Fpdf
 *
 */
public class ArrayChallenge {

    // Holds the base coordinates of each element that is to be used to generate the sum. The challenge
    // uses a hour glass shaped template. However this variable will allow for the use of any template shape.
    private Coordinate[] template = {
            new Coordinate(0,0), new Coordinate(0,1), new Coordinate(0,2),
            new Coordinate(1,1), new Coordinate(2,0), new Coordinate(2,1),
            new Coordinate(2,2)};

    private int[][] arr;

    public static void main(String[] args) {
        ArrayChallenge ac = new ArrayChallenge();
        Scanner in = new Scanner(System.in);
        ac.arr = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                ac.arr[i][j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(ac.getMaxTemplateSum());
    }

    // Position the template over the input array and calculate the sum. Returns the largest sum found.
    public int getMaxTemplateSum() {
        // Determine size of 2D input array.
        int numRows = this.arr.length;
        int numCols = this.arr[0].length;


        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int sum = sumTemplate(row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    // Calculates the sum of the template positioned at the coordinates given.
    public int sumTemplate(int row, int col) {
        int sum = 0;
        // Calculate the sum of all of the elements specified by the template.
        for (int i = 0; i < template.length; i++) {
            try {
                int r = template[i].getRow() + row;
                int c = template[i].getCol() + col;
                sum += this.arr[r][c];
            } catch (ArrayIndexOutOfBoundsException e) {
                // Part of the template is outside the bounds of the input array.
                return Integer.MIN_VALUE;
            }
        }
        return sum;
    }

    private class Coordinate {

        private int row, col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
