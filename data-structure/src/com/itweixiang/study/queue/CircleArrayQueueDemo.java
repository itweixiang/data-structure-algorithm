package com.itweixiang.study.queue;

/**
 * 队列
 *
 * 特点，先进先出
 * 可以由数组或者链表实现
 *
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {


        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        for (int i = 0; i < 4; i++) {
            circleArrayQueue.add(i);
        }
        circleArrayQueue.print();
        System.out.println("------");
        System.out.println(circleArrayQueue.get());
        System.out.println("------");
        System.out.println(circleArrayQueue.peak());
        circleArrayQueue.print();
        circleArrayQueue.add(6);
        circleArrayQueue.print();
        circleArrayQueue.add(7);
    }
}
