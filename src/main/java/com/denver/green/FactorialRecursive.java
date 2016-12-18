package com.denver.green;

/**
 * Created by Denver on 12/17/2016.
 */
public class FactorialRecursive {
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
