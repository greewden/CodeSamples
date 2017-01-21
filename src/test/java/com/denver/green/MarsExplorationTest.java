package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/13/2017.
 */
public class MarsExplorationTest {
    @Test
    public void numLettersAltered() throws Exception {
        String base = "SOS";
        String message = "SOSSPSSQSSOR";

        assertEquals(3, MarsExploration.numLettersAltered(base, message));
    }

}