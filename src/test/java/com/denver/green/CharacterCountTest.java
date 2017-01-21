package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/18/2016.
 */
public class CharacterCountTest {
    @Test
    public void countChar() throws Exception {
        String s = "aba";
        long n = 10;
        char c = 'a';
        assertEquals(7, CharacterCount.countChar(s, n, c));
    }

}