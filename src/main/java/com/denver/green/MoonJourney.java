package com.denver.green;

import edu.princeton.cs.algs4.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Denver on 1/14/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/784-journey-to-the-moon-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1484544157&Signature=A80hva0ZXNuiVvhxOwDkEkPifxE%3D&response-content-disposition=inline%3B%20filename%3Djourney-to-the-moon-English.pdf&response-content-type=application%2Fpdf
 */
public class MoonJourney {
    private boolean[] visited;
    private Graph g;

    public MoonJourney(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create a graph representing the astronauts. This will be a disjointed graph with astronauts belonging to
        // the same country being in the same connected sub-graph.
        Graph g = new Graph(in);
        MoonJourney journey = new MoonJourney(g);
        System.out.println(journey.calcAstronautPairs());
    }

    /**
     * Calculates the total number of pairs of astronauts belonging to different countries that
     * can be created from the list of astronauts provided. This is done by first calculating the
     * total number of ways of choosing two astronauts from the set of astronauts regardless of
     * country (N choose 2). There is n ways of selecting the first element and (n-1) ways to choose the second
     * astronaut as you cannot select the same astronaut twice. So the formula is n(n-1) however this
     * double counts each pair. That is {A, B} and {B, A} is counted twice. To fix this we need to
     * divide by 2 so the formula for calculating N choose 2 becomes:
     *      n(n-1)/2
     * Once we have the total we need to subtract the number of ways you can choose astronauts from the
     * same country fo each country resulting in the formula.
     *
     *       Ways = N choose 2 - (∑(Mi Choose 2) for i = 1 to M where M is the number of countries)
     *
     * @return number of possible pairs from different countries that can be made.
     */
    public long calcAstronautPairs() {
        int totalAstronauts = g.V();
        long totalNumberOfWays = nChoose2(totalAstronauts);

        for (int astronaut = 0; astronaut < totalAstronauts; astronaut++) {
            // Go to next astronaut if this one was already visited
            if (visited[astronaut]) {
                continue;
            }

            int countryMenCount = countCountryMen(astronaut);
            totalNumberOfWays -= nChoose2(countryMenCount);
        }

        return totalNumberOfWays;
    }

    /**
     * Does a breadth first traversal of the graph of astronauts starting at the given
     * astronaut and counts the number of different astronauts encountered. This count
     * is the total number of astronauts that are from the same country as the given
     * astronaut.
     *
     * @param astronaut to start the graph traversal from.
     * @return total numbers of nodes encountered during the traversal.
     */
    public int countCountryMen(int astronaut) {
        // count records the number of astronauts that are from the same country
        // as the given astronaut
        int count = 0;

        // queue of countrymen yet to be visited.
        Queue<Integer> toBeVisited = new LinkedList<>();

        // add astronaut to the the to be visited queue and mark her as visited.
        toBeVisited.add(astronaut);
        visited[astronaut] = true;
        while (!toBeVisited.isEmpty()) {
            astronaut = toBeVisited.remove();
            count++;

            // add astronauts that are from the same country as the
            // current astronaut to the to be visited queue if they
            // have not already been visited.
            for (int a : g.adj(astronaut)) {
                if (!visited[a]) {
                    toBeVisited.add(a);
                    // mark astronaut as visited and increment astronaut count
                    visited[a] = true;
                }
            }
        }
        return count;
    }

    /**
     * Calculates the number of ways to choose two elements out of n elements.
     *
     * @param n is the number of elements to be choosen from.
     * @return number of different ways 2 elements can be choosen from the n elements.
     */
    public long nChoose2(long n) {
        return n * (n - 1) / 2;
    }
}