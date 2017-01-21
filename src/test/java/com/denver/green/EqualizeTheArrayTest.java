package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/16/2016.
 */
public class EqualizeTheArrayTest {
    @Test
    public void calcNumOfDeletions() throws Exception {
        int[] in = {3, 3, 2, 1, 3};
        int result = EqualizeTheArray.calcNumOfDeletions(in);

        assertEquals(2, result);
    }
}