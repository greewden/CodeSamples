package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/21/2016.
 */
public class SockMerchantTest {
    @Test
    public void countMatching() throws Exception {
        int[] in = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int expected = 3;
        assertEquals(expected, SockMerchant.countMatching(in));
    }

}