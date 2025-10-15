package com.mackenzie.model;

// Gabriel Ferreira - RA: 10442043
// Gian Lucca Campanha Ribeiro - RA: 10438361
// Kaiki Bellini Barbosa - RA: 10402509

public class AVL extends BST {

    public AVL() {
        super();
    }

    public AVL(Node root) {
        super(root);
    }

    private void updateParentChild(Node parent, final Node child, Node newChild) {
        if (parent != null) {
            if (parent.getLeft() == child) {
                parent.setLeft(newChild);
            } else {
                parent.setRight(newChild);
            }
        } else {
            root = newChild;
            if (newChild != null) {
                newChild.setParent(null);
            }
        }
    }

    private Node rotateLeft(Node node) {
        if (node == null) return null;

        Node newRoot = node.getRight();
        if (newRoot == null) return node;

        Node parent = node.getParent();
        updateParentChild(parent, node, newRoot);

        Node left = newRoot.getLeft();
        node.setRight(left);

        newRoot.setLeft(node);

        return newRoot;
    }

    private Node rotateRight(Node node) {
        if (node == null) return null;

        Node newRoot = node.getLeft();
        if (newRoot == null) return node;

        Node parent = node.getParent();
        updateParentChild(parent, node, newRoot);

        Node right = newRoot.getRight();
        node.setLeft(right);

        newRoot.setRight(node);

        return newRoot;
    }

    private Node rotateLeftRight(Node node) {
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
    }

    private Node rotateRightLeft(Node node) {
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = node.getBalanceFactor();

        if (balanceFactor < -1) {
            if (node.getLeft().getBalanceFactor() > 0) {
                System.out.println("-> Rotação Dupla à Direita (LR) aplicada no nó " + node.getData());
                node = rotateLeftRight(node);
            }
            else {
                System.out.println("-> Rotação Simples à Direita (RR) aplicada no nó " + node.getData());
                node = rotateRight(node);
            }
        }
        else if (balanceFactor > 1) {
            if (node.getRight().getBalanceFactor() < 0) {
                System.out.println("-> Rotação Dupla à Esquerda (RL) aplicada no nó " + node.getData());
                node = rotateRightLeft(node);
            }
            else {
                System.out.println("-> Rotação Simples à Esquerda (LL) aplicada no nó " + node.getData());
                node = rotateLeft(node);
            }
        }

        return node;
    }

    @Override
    public void insert(int data) {
        root = insert(root, null, data);
    }

    @Override
    protected Node insert(Node node, Node parent, int data) {
        node = super.insert(node, parent, data);
        return balance(node);
    }

    @Override
    public void remove(int data) {
        root = remove(root, data);
    }

    @Override
    protected Node remove(Node node, int data) {
        node = super.remove(node, data);
        if (node == null) {
            return null;
        }
        return balance(node);
    }
}