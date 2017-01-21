package com.denver.green;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Denver on 1/3/2017.
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/17176-30-binary-trees-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1483484465&Signature=iTdfr2D1ZkyFbimXRYGM5iG3E88%3D&response-content-disposition=inline%3B%20filename%3D30-binary-trees-English.pdf&response-content-type=application%2Fpdf
 * https://hackerrank-challenge-pdfs.s3.amazonaws.com/17175-30-binary-search-trees-English?AWSAccessKeyId=AKIAJAMR4KJHHUS76CYQ&Expires=1483484534&Signature=ByC98bNPb94XVdQ960C%2By8zmX7U%3D&response-content-disposition=inline%3B%20filename%3D30-binary-search-trees-English.pdf&response-content-type=application%2Fpdf
 */
public class BinarySearchTree {
    static Queue<Integer> printQ = new LinkedList<>();

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
        levelOrder(root);
    }

    public static int getHeight(Node root) {
        int heightLeft = 0, heightRight = 0;
        if (root.left != null) {
            heightLeft = getHeight(root.left) + 1;
        }

        if (root.right != null) {
            heightRight = getHeight(root.right) + 1;
        }
        return (heightLeft >= heightRight) ? heightLeft : heightRight;
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            printQ.add(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}

