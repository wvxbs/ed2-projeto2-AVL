package com.mackenzie.view;

// Gabriel Ferreira - RA: 10442043
// Gian Lucca Campanha Ribeiro - RA: 10438361
// Kaiki Bellini Barbosa - RA: 10402509

import com.mackenzie.model.AVL;

public class TreeView {
    public void displayTreeState(String title, AVL tree) {
        System.out.println("=========================================================");
        System.out.println(title);

        System.out.println("\nÁrvore Resultante (percurso por nível):");
        String treeData = tree.levelOrderTraversal();

        if (treeData.isEmpty()) {
            System.out.println("Árvore está vazia.");
        } else {
            System.out.println(treeData);
        }
    }
}