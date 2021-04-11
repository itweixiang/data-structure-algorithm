package com.itweixiang.study.tree;

public class ThreadedNode extends Node {
    /**
     * 如果leftType == 0，表示指向的是左子树，如果等于1，则表示指向前驱节点
     */
    int leftType;
    /**
     * 如果等于1，则指向后继节点
     */
    int rightType;

    public ThreadedNode(int data) {
        super(data);
    }
}
