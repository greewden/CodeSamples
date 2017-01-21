package com.denver.green;

import edu.princeton.cs.algs4.Graph;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/15/2017.
 */
public class MoonJourneyTest {
    private Graph g;

    @Before
    public void setUp() throws Exception {
        // Locate input file describing graph and create an input stream that
        // will read from it.
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);
        FileInputStream fis = new FileInputStream("src\\test\\resources\\testCase11_ans_4999949998.txt");
        Scanner in = new Scanner(new BufferedInputStream(fis));

        g = new Graph(in);
        //System.out.println(g);
    }

    @Test
    public void calcAstronautPairs() throws Exception {
        MoonJourney journey = new MoonJourney(g);
        assertEquals(4999949998L, journey.calcAstronautPairs());
    }

    @Test
    public void countCountryMen() throws Exception {
        MoonJourney journey = new MoonJourney(g);
        assertEquals(2, journey.countCountryMen(3));
    }

}