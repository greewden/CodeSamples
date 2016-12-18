package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/17/2016.
 */
public class factorialRecursiveTest {
    @Test
    public void factorial() throws Exception {
        int result = FactorialRecursive.factorial(4);
        assertEquals(24, result);
    }

}