package com.denver.green;

import java.util.Scanner;

/**
 * Created by Denver on 12/21/2016.
 */
public class ScoreHackerProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        HackerRankScore alice = new HackerRankScore(a0, a1, a2);
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        HackerRankScore bob = new HackerRankScore(b0, b1, b2);
        in.close();
        int[] results = compare(alice, bob);
        System.out.printf("%d %d\n", results[0], results[1]);
    }

    public static int[] compare(HackerRankScore a, HackerRankScore b) {
        int scoreA = 0, scoreB = 0;
        if (a.getClarity() > b.getClarity()) scoreA++;
        if (b.getClarity() > a.getClarity()) scoreB++;
        if (a.getDifficulty() > b.getDifficulty()) scoreA++;
        if (b.getDifficulty() > a.getDifficulty()) scoreB++;
        if (a.getOriginality() > b.getOriginality()) scoreA++;
        if (b.getOriginality() > a.getOriginality())scoreB++;
        return new int[]{scoreA, scoreB};
    }

    static class HackerRankScore {
        private int clarity;
        private int originality;
        private int difficulty;

        HackerRankScore(int clarity, int originality, int difficulty) {
            this.clarity = clarity;
            this.originality = originality;
            this.difficulty = difficulty;
        }

        public int getClarity() {
            return clarity;
        }

        public int getOriginality() {
            return originality;
        }

        public int getDifficulty() {
            return difficulty;
        }
    }
}
