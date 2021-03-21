package com.itweixiang.study.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.headAdd(i);
        }
        linkedList.headPrint();
        System.out.println("--------");
        linkedList.tailPrint();
        System.out.println("--------");
        for (int i = 0; i < 5; i++) {
            linkedList.tailAdd(i);
        }
        linkedList.headPrint();
    }
}
