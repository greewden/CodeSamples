package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Denver on 1/13/2017.
 */
public class BonAppetitTest {
    @Test
    public void calcAmtOwed() throws Exception {
        int[] costs = {3, 10, 2, 9};
        int notEaten = 1;
        assertEquals(7, BonAppetit.calcAmtOwed(costs, notEaten));
    }

    @Test
    public void invalidAmountCharged() throws Exception {
        int amtCharged = 12;
        int amtOwed = 7;

        assertEquals("5", BonAppetit.validateAmountCharged(amtCharged, amtOwed));
    }

    @Test
    public void validAmountCharged() throws Exception {
        int amtCharged = 12;
        int amtOwed = 12;

        assertEquals("Bon Appetit", BonAppetit.validateAmountCharged(amtCharged, amtOwed));

    }
}