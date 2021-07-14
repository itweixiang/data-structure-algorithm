package top.itweixiang.study.linkedlist;

public class JosephusLinkedList extends CircleLinkedList {

    public int del(int k) {
        Node pre = head;
        while (k != 1 && head != head.next) {
            pre = head;
            head = head.next;
            k--;
        }
        Integer data = head.data;
        pre.next = head.next;
        head = head.next;
        return data;
    }
}
