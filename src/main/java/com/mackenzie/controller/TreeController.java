package com.mackenzie.controller;

// Gabriel Ferreira - RA: 10442043
// Gian Lucca Campanha Ribeiro - RA: 10438361
// Kaiki Bellini Barbosa - RA: 10402509

import com.mackenzie.model.AVL;
import com.mackenzie.view.TreeView;

public class TreeController {

    private final TreeView view;
    private AVL avl;

    public TreeController(TreeView view) {
        this.view = view;
    }

    public void runAllTestCases() {
        testSimpleLeftRotation();
        testSimpleRightRotation();
        testLeftRightRotation();
        testRightLeftRotation();
        testComplexInsertionAndRemovals();
    }

    private void testSimpleLeftRotation() {
        avl = new AVL();
        String title = "a) Inserir, nessa ordem, os nós com chaves 1, 2 e 3.";
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        view.displayTreeState(title, avl);
    }

    private void testSimpleRightRotation() {
        avl = new AVL();
        String title = "b) Inserir, nessa ordem, os nós com chaves 3, 2 e 1.";
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
        view.displayTreeState(title, avl);
    }

    private void testLeftRightRotation() {
        avl = new AVL();
        String title = "c) Inserir, nessa ordem, os nós com chaves 3, 1 e 2.";
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
        view.displayTreeState(title, avl);
    }

    private void testRightLeftRotation() {
        avl = new AVL();
        String title = "d) Inserir, nessa ordem, os nós com chaves 1, 3 e 2.";
        avl.insert(1);
        avl.insert(3);
        avl.insert(2);
        view.displayTreeState(title, avl);
    }

    private void testComplexInsertionAndRemovals() {
        avl = new AVL();
        String titleE = "e) Inserir, nessa ordem, 5, 4, 3, 1, 2, 6, 7, 9 e 8.";
        avl.insert(5);
        avl.insert(4);
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
        avl.insert(6);
        avl.insert(7);
        avl.insert(9);
        avl.insert(8);
        view.displayTreeState(titleE, avl);

        String titleF = "f) Remover o nó 4 da árvore do item (e).";
        avl.remove(4);
        view.displayTreeState(titleF, avl);

        String titleG = "g) Remover o nó 5 da árvore do item (f).";
        avl.remove(5);
        view.displayTreeState(titleG, avl);

        String titleH = "h) Remover o nó 1 da árvore do item (g).";
        avl.remove(1);
        view.displayTreeState(titleH, avl);
    }
}