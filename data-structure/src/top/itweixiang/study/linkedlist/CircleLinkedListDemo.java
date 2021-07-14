package top.itweixiang.study.linkedlist;

public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList linkedList = new CircleLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        linkedList.print();
    }
}
