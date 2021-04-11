package com.itweixiang.study.tree;

public class BinaryBalancedTreeDemo {
    public static void main(String[] args) {
        BinaryBalancedTree tree = new BinaryBalancedTree();
        tree.add(new Node(1));
        Node node = new Node(2);
        tree.add(node);
        tree.add(new Node(3));
        tree.add(new Node(3));
        tree.add(new Node(3));
        tree.add(new Node(4));
        Node node1 = new Node(5);
        tree.add(node1);
        tree.add(new Node(6));
        tree.add(new Node(6));
        tree.add(new Node(6));
        tree.add(new Node(7));
        tree.add(new Node(100));
        tree.infix(tree.root);
    }
}
