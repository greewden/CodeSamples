package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/8/2017.
 */
public class BitwiseAnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {
            int endValue = in.nextInt();
            int maxValue = in.nextInt();
            int max = 0;
            for (int a = 0; a < endValue ; a++) {
                for (int b = a + 1; b <= endValue ; b++) {
                    int tmp = a & b;
                    if (tmp < maxValue && tmp > max) {
                        max = tmp;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
