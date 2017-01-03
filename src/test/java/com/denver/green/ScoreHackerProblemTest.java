package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Denver on 12/21/2016.
 */
public class ScoreHackerProblemTest {
    @Test
    public void compare() throws Exception {

        ScoreHackerProblem.HackerRankScore anne = new ScoreHackerProblem.HackerRankScore(5, 6, 7);
        ScoreHackerProblem.HackerRankScore bob = new ScoreHackerProblem.HackerRankScore(3, 6, 10);

        int[] results = ScoreHackerProblem.compare(anne, bob);
        int[] expected = {1, 1};

        assertArrayEquals(expected, results);
    }

}