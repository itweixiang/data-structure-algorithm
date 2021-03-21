package com.itweixiang.study.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
        linkedList.print();

        System.out.println("-------");
        System.out.println(linkedList.get(10));
        System.out.println(linkedList.size());
        System.out.println(linkedList.tail(10));
    }
}
