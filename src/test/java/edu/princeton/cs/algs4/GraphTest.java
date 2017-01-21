package edu.princeton.cs.algs4;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/15/2017.
 */
public class GraphTest {
    @Test
    public void TestGraphCreateFromFile() throws FileNotFoundException {
        // Locate input file describing graph and create an input stream that
        // will read from it.
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);
        FileInputStream fis = new FileInputStream("src\\test\\resources\\tinyG.txt");
        Scanner in = new Scanner(new BufferedInputStream(fis));

        Graph g = new Graph(in);
        System.out.println(g);
        // Number of vertices in the created graph should be 13.
        assertEquals(13, g.V());
        // Number of edged in the created graph should be 13.
        assertEquals(13, g.E());
    }
}