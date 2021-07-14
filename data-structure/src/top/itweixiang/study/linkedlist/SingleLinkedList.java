package top.itweixiang.study.linkedlist;

public class SingleLinkedList {
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

    public int get(int index) {
        int count = 0;
        Node temp = head;
        while (count != index) {
            temp = temp.next;
            count++;
        }
        return temp.data;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public int size() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int tail(int index) {
        int count = size() - index;
        Node node = head;
        while (count!=0){
            node = node.next;
            count--;
        }
        return node.data;
    }

}
