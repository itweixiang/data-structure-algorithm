package com.itweixiang.study.queue;


import com.itweixiang.study.linkedlist.Node;

public class LinkedListQueue {

    private Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public Integer get (){
        if (head==null){
            throw new RuntimeException("queue is empty");
        }else{
            Node temp = head;
            head = head.next;
            return temp.data;
        }
    }

    public void print() {
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public int peak(){
        if (head==null){
            throw new RuntimeException("queue is empty");
        }else{
            return head.data;
        }
    }
}
