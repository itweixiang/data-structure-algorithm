package com.itweixiang.study.queue;

public class ArrayQueue1 {
    private int[] array;
    /**
     * 前端，出队时改变
     */
    private int front;
    /**
     * 后端，入队时改变
     */
    private int rear;

    /**
     * 大小
     *
     * @param size
     */
    private Integer size;

    public ArrayQueue1(int size) {
        array = new int[size];
        front = -1;//指向队列头部的前一个位置
        rear = -1;
        this.size = size;
    }

    public void add(int i) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        array[++rear] = i;
    }

    public Integer get() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        } else {
            return array[++front];
        }
    }

    public Boolean isFull() {
        return rear == size - 1;
    }

    public Boolean isEmpty() {
        return rear == front;
    }

    public void print(){
        int temp = front+1;
        for (int i = temp; i <= rear; i++) {
            System.out.println(array[i]);
        }
    }

    public Integer peak(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        int temp = front+1;
        return array[temp];
    }
}
