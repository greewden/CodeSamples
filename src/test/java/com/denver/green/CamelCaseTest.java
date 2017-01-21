package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/21/2016.
 */
public class CamelCaseTest {
    @Test
    public void countWords() throws Exception {
        int actual = CamelCase.countWords("saveChangesInTheEditor");
        assertEquals(5, actual);
    }

}