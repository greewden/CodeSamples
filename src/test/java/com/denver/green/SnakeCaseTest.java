package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/21/2016.
 */
public class SnakeCaseTest {
    @Test
    public void countWords() throws Exception {
        String s = "have_a_nice_day";
        int expected = 4;
        int actual = SnakeCase.countWords(s);
        assertEquals(expected, actual);
    }

}