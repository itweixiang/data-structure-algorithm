package com.itweixiang.study.queue;

/**
 * 队列
 *
 * 特点，先进先出
 * 可以由数组或者链表实现
 *
 */
public class QueueDemo {
    public static void main(String[] args) {
//        ArrayQueue1 arrayQueue1 = new ArrayQueue1(5);
//        for (int i = 0; i < 3; i++) {
//            arrayQueue1.add(i);
//        }
//        arrayQueue1.print();
//        System.out.println("------");
//        System.out.println(arrayQueue1.get());
//        System.out.println("------");
//        System.out.println(arrayQueue1.peak());
//        arrayQueue1.print();
//

        ArrayQueue2 arrayQueue2 = new ArrayQueue2(5);
        for (int i = 0; i < 4; i++) {
            arrayQueue2.add(i);
        }
        arrayQueue2.print();
        System.out.println("------");
        System.out.println(arrayQueue2.get());
        System.out.println("------");
        System.out.println(arrayQueue2.peak());
        arrayQueue2.print();
        arrayQueue2.add(6);
        arrayQueue2.print();
        arrayQueue2.add(7);
    }
}
