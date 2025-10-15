package com.mackenzie;

// Gabriel Ferreira - RA: 10442043
// Gian Lucca Campanha Ribeiro - RA: 10438361
// Kaiki Bellini Barbosa - RA: 10402509

import com.mackenzie.controller.TreeController;
import com.mackenzie.view.TreeView;

public class Main {
    public static void main(String[] args) {
        TreeView view = new TreeView();
        TreeController controller = new TreeController(view);
        controller.runAllTestCases();
    }
}