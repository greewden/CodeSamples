package com.denver.green;

import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Denver on 12/22/2016.
 */
public class LeaderBoard {
    private NavigableMap<Integer, Integer> leaderBoard;

    public LeaderBoard(NavigableMap<Integer, Integer> map) {
        this.leaderBoard = map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        NavigableMap<Integer, Integer> board = new TreeMap<>();
        int rank = 1;
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
            if (!board.containsKey(scores[scores_i])) {
                board.put(scores[scores_i], rank++);
            }
        }
        LeaderBoard leaderBoard = new LeaderBoard(board);

        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
            System.out.println(leaderBoard.getRank(alice[alice_i]));
        }
        in.close();
    }

    public int getRank(int score) {
        Integer higherScore = leaderBoard.ceilingKey(score);
        if (higherScore == null) {
            return 1;
        }

        if (higherScore == score) {
            return leaderBoard.get(higherScore);
        }
        return leaderBoard.get(higherScore) + 1;
    }
}
