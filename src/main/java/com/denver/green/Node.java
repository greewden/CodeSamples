package com.denver.green;

public class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node insert(Node left, Node right) {
        this.left = left;
        this.right = right;
        return this;
    }

    Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    Node setRight(Node right) {
        this.right = right;
        return this;
    }
}
