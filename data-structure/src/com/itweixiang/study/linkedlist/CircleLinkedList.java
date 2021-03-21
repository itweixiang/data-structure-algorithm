package com.itweixiang.study.linkedlist;

public class CircleLinkedList {
    public Node head;
    public void add(int d){
        if (head ==null){
            head = new Node(d);
            head.next = head;
        }else{
            Node temp = head;
            while (temp.next!=head){
                temp = temp.next;
            }
            temp.next = new Node(d);
            temp.next.next = head;
        }
    }

    public void print(){
        Node temp = head;
        while (temp.next != head){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
