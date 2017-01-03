package com.denver.green;

import org.junit.Test;

import java.util.NavigableMap;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 12/22/2016.
 */
public class LeaderBoardTest {
    @Test
    public void getRank() throws Exception {
        NavigableMap<Integer, Integer> board = new TreeMap<>();
        board.put(100, 1);
        board.put(100, 1);
        board.put(50, 2);
        board.put(40, 3);
        board.put(40, 3);
        board.put(20, 4);
        board.put(10, 5);

        LeaderBoard leaderBoard = new LeaderBoard(board);
        assertEquals(6, leaderBoard.getRank(5));
        System.out.printf("Rank = %d\n", leaderBoard.getRank(5));
        assertEquals(4, leaderBoard.getRank(25));
        System.out.printf("Rank = %d\n", leaderBoard.getRank(25));
        assertEquals(2, leaderBoard.getRank(50));
        System.out.printf("Rank = %d\n", leaderBoard.getRank(50));
        assertEquals(1, leaderBoard.getRank(120));
        System.out.printf("Rank = %d\n", leaderBoard.getRank(120));
    }

}