package com.itweixiang.study.queue;

public class LinkedListQueueDemo {
    public static void main(String[] args) {
        LinkedListQueue listQueue = new LinkedListQueue();
        for (int i = 0; i < 4; i++) {
            listQueue.add(i);
        }
        listQueue.print();
        System.out.println("------");
        System.out.println(listQueue.get());
        System.out.println("------");
        System.out.println(listQueue.peak());
        listQueue.print();
        listQueue.add(6);
        listQueue.print();
    }
}
