package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/26/2017.
 */
public class CoinChangeTest {
    @Test
    public void makeChange() throws Exception {
        int[] denominations = {2, 3, 5, 6};
        int availDenom = denominations.length;
        int amount = 10;

        assertEquals(5, CoinChange.makeChange(denominations, availDenom, amount));
    }

}