package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Denver on 12/8/2016.
 */
public class ArrayLeftRotationTest {
    @Test
    public void TypicalInput() throws Exception {
        // Test typical input where there are several elements and number of rotations is > 1.
        int[] input = {1, 2, 3, 4, 5};
        int rotations = 3;
        int numberofElements = 5;
        int[] expected = {4, 5, 1, 2, 3};
        int [] actual = ArrayLeftRotation.arrayLeftRotation(input, numberofElements, rotations);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void RotationSetToOne() {
        // Test typical input where there are several elements and number of rotations is > 1.
        int[] input = {1, 2, 3, 4, 5};
        int rotations = 1;
        int numberofElements = 5;
        int[] expected = {2, 3, 4, 5, 1};
        int [] actual = ArrayLeftRotation.arrayLeftRotation(input, numberofElements, rotations);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void RotationSetToZero() {
        // Test typical input where there are several elements and number of rotations is > 1.
        int[] input = {1, 2, 3, 4, 5};
        int rotations = 0;
        int numberofElements = 5;
        int[] expected = {1, 2, 3, 4, 5};
        int [] actual = ArrayLeftRotation.arrayLeftRotation(input, numberofElements, rotations);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void RotationsLargerThanNumberOfElements() {
        // Test typical input where there are several elements and number of rotations is > numberOfElements.
        int[] input = {1, 2, 3, 4, 5};
        int rotations = 6;
        int numberofElements = 5;
        int[] expected = {2, 3, 4, 5, 1};
        int [] actual = ArrayLeftRotation.arrayLeftRotation(input, numberofElements, rotations);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ArrayOfOneElement() {
        int[] input = {8};
        int rotations = 5;
        int numberofElements = 1;
        int[] expected = {8};
        int [] actual = ArrayLeftRotation.arrayLeftRotation(input, numberofElements, rotations);
        assertArrayEquals(expected, actual);
    }
}