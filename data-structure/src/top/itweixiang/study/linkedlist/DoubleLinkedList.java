package top.itweixiang.study.linkedlist;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    public void headAdd(int d){
        if (head == null){
            head = new Node(d);
            tail = head;
        }else{
            Node temp = new Node(d);
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
    }
    public void tailAdd(int d){
        if (tail ==null){
            tail = new Node(d);
            head = tail;
        }else{
            Node temp = new Node(d);
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        }
    }
    public void headPrint(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void tailPrint(){
        Node temp = tail;
        while (temp!=null){
            System.out.println(temp.data);
            temp = temp.previous;
        }
    }
}
