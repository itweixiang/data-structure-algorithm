package com.itweixiang.study.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        tree.add(new Node(5));
        Node node = new Node(2);
        tree.add(node);
        tree.add(new Node(1));
        tree.add(new Node(4));
        Node node1 = new Node(9);
        tree.add(node1);
        tree.add(new Node(6));
        tree.add(new Node(7));
        tree.add(new Node(100));
        tree.infix(tree.root);
        tree.delete(tree.root);
        System.out.println();
        tree.infix(tree.root);
    }
}
