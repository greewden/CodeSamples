package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Denver on 1/2/2017.
 */
public class BubbleSortTest {
    @Test
    public void bubbleSort() throws Exception {
        int[] a = { 23, 89, 1, -56, 5};
        BubbleSort.bubbleSort(a);
        assertArrayEquals(new int[] {-56, 1, 5, 23, 89}, a);
    }
}