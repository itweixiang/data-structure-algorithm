package com.itweixiang.study.tree;


public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(array);
        tree.pre(0);
    }
}
