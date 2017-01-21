package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denver on 1/3/2017.
 */
public class PrimeTest {
    @Test
    public void isPrime() throws Exception {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(13));
        assertFalse(Prime.isPrime(25));
        assertFalse(Prime.isPrime(6));
    }
}