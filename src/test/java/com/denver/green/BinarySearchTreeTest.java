package com.denver.green;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by Denver on 1/3/2017.
 */
public class BinarySearchTreeTest {
    @Test
    public void levelOrder() throws Exception {
        // Create tree to be tested.
        //
        //          110
        //      80       150
        //           120     40
        Node node = new Node(150);
        node.setLeft(new Node(120));
        node.setRight(new Node(40));
        Node root = new Node(110);
        root.setLeft(new Node(80));
        root.setRight(node);

        Queue<Integer> expected = new LinkedList<Integer>();
        expected.add(110);
        expected.add(80);
        expected.add(150);
        expected.add(120);
        expected.add(40);
        BinarySearchTree.levelOrder(root);
        assertEquals(expected, BinarySearchTree.printQ);
    }

    @Test
    public void getHeight() {
        // Create tree to be tested.
        //
        //          110
        //      80       150
        //           120     40
        Node node = new Node(150);
        node.setLeft(new Node(120));
        node.setRight(new Node(40));
        Node root = new Node(110);
        root.setLeft(new Node(80));
        root.setRight(node);
        assertEquals(2, BinarySearchTree.getHeight(root));
    }
}