package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by degreen on 2016-12-21.
 */
public class ArrayChallengeTest {
    @Test
    public void getMaxTemplateSum() throws Exception {

        int[][] arr = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}};

        ArrayChallenge ac = new ArrayChallenge();
        int result = ac.getMaxTemplateSum();
        assertEquals(-19, result);
    }
}