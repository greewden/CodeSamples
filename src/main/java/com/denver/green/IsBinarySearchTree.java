package com.denver.green;

import java.util.ArrayList;

/**
 * Given the root node of a tree, determine if the tree is a binary search tree.
 *
 * @author Denver Green
 */
public class IsBinarySearchTree {

    static private ArrayList<Integer> bstElements = new ArrayList<>();

    /**
     * Determines if the provided node is the root of a binary search tree.
     * https://hackerrank-challenge-pdfs.s3.amazonaws.com/23952-ctci-is-binary-search-tree-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1481314226&Signature=AZZVBTEyjI5brmFOVEZbRwz%2BRNs%3D&response-content-disposition=inline%3B%20filename%3Dctci-is-binary-search-tree-English.pdf&response-content-type=application%2Fpdf
     *
     * @param root - the root of the tree.
     * @return true if root is a binary search tree.
     */
    static boolean checkBST(Node root) {
        // Determine if node is a BST by doing an inorder traversal of the tree and verify that each
        // element is returned in sorted order.
        bstElements.clear();
        inOrderTraversal(root);
        int previous = Integer.MIN_VALUE;
        int current;
        for (Integer e : bstElements) {
            if (e <= previous) {
                return false;
            }
            previous = e;
        }
        return true;
    }

    static void inOrderTraversal(Node node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        bstElements.add(node.data);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }
}

