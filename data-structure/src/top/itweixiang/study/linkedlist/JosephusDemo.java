package top.itweixiang.study.linkedlist;

public class JosephusDemo {
    public static void main(String[] args) {
        JosephusLinkedList linkedList = new JosephusLinkedList();
        for (int i = 1; i < 6; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(linkedList.del(3));
        }
    }
}
