package com.mackenzie.model;

// Gabriel Ferreira - RA: 10442043
// Gian Lucca Campanha Ribeiro - RA: 10438361
// Kaiki Bellini Barbosa - RA: 10402509

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    protected Node root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getDegree() {
        return getDegree(root);
    }

    private int getDegree(Node node) {
        if (node == null || node.isLeaf()) {
            return 0;
        }

        int degree = node.getDegree();

        if (node.hasLeftChild()) {
            degree = Math.max(degree, getDegree(node.getLeft()));
        }

        if (node.hasRightChild()) {
            degree = Math.max(degree, getDegree(node.getRight()));
        }

        return degree;
    }

    public int getHeight() {
        if (isEmpty()) {
            return -1;
        }

        return root.getHeight();
    }

    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(sb, root);
        return sb.toString();
    }

    private void inOrderTraversal(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(sb, node.getLeft());
        sb.append(node + "\n");
        inOrderTraversal(sb, node.getRight());
    }

    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(sb, root);
        return sb.toString();
    }

    private void preOrderTraversal(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }

        sb.append(node + "\n");
        preOrderTraversal(sb, node.getLeft());
        preOrderTraversal(sb, node.getRight());
    }

    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversal(sb, root);
        return sb.toString();
    }

    private void postOrderTraversal(StringBuilder sb, Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(sb, node.getLeft());
        postOrderTraversal(sb, node.getRight());
        sb.append(node + "\n");
    }

    public String levelOrderTraversal() {
        if (isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node visited = queue.remove();
            sb.append(visited + "\n");

            if (visited.hasLeftChild()) {
                queue.add(visited.getLeft());
            }
            if (visited.hasRightChild()) {
                queue.add(visited.getRight());
            }
        }

        return sb.toString();
    }
}