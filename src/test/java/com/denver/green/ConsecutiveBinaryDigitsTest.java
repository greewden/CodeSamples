package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by degreen on 2016-12-19.
 */
public class ConsecutiveBinaryDigitsTest {
    @Test
    public void countConsecutiveOnes() throws Exception {
        assertEquals(3, ConsecutiveBinaryDigits.countConsecutiveOnes(439));

    }

}