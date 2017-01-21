package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 1/3/2017.
 */
public class Prime {
    public static boolean isPrime(long n) {
        if (n <= 1) {
            // Prime numbers must be larger than 1
            return false;
        } else if (n <= 3) {
            // 1, 2, 3 are prime numbers.
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            // numbers divisible by 2 or 3 are not prime.
            return false;
        }
        // i is the divisor that will be used to test n. Start at 5 as 4 is an even number and
        // the test using 2 as a divisor has already been done.
        int divisor = 5;

        // Only need to test divisors up to √n
        while (divisor * divisor <= n) {
            if (n % divisor == 0 || n % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int i = 0; i < count; i ++) {
            if (Prime.isPrime(in.nextInt())) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
        in.close();
    }
}
