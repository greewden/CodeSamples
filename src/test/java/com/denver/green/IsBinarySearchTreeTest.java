package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denver on 12/9/2016.
 */
public class IsBinarySearchTreeTest {
    @Test
    public void checkBSTFail() {
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

        assertFalse(IsBinarySearchTree.checkBST(root));
    }

    @Test
    public void checkBstPass() {
        // Create tree to be tested
        //
        //          50
        //      25      65
        //         35      99
        Node node = new Node(65);
        node.setRight(new Node(99));
        Node root = new Node(50);
        root.setRight(node);
        node = new Node(25);
        node.setRight(new Node(35));
        root.setLeft(node);

        assertTrue(IsBinarySearchTree.checkBST(root));
    }
}