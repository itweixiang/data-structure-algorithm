package top.itweixiang;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 《两个链表生成相加链表》
 * <p>
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 */
public class NC40 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode tmp = head1;
        while (tmp != null) {
            s1.add(tmp.val);
            tmp = tmp.next;
        }
        tmp = head2;
        while (tmp != null) {
            s2.add(tmp.val);
            tmp = tmp.next;
        }
        int pre = 0;
        ListNode head = null;
        while (true) {
            int val = 0;
            if (!s1.isEmpty()) {
                val += s1.pop();
            }
            if (!s2.isEmpty()) {
                val += s2.pop();
            }
            if (pre != 0) {
                val += pre;
            }
            pre = val / 10;
            if (head == null) {
                head = new ListNode(val % 10);
            } else {
                ListNode node = new ListNode(val % 10);
                node.next = head;
                head = node;
            }
            if (s1.isEmpty() && s2.isEmpty()) {
                break;
            }
        }

        if (pre != 0) {
            ListNode node = new ListNode(pre);
            node.next = head;
            head = node;
        }
        return head;
    }
    /*
    LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        ListNode tmp = head1;
        while (tmp!=null){
            l1.addLast(tmp.val);
            tmp = tmp.next;
        }
        tmp = head2;
        while (tmp!=null){
            l2.addLast(tmp.val);
            tmp = tmp.next;
        }
        if (l2.size()<l1.size()){
            int sub = l1.size() - l2.size();
            for (int i = 0; i < sub; i++) {
                l2.addFirst(0);
            }
        }else if (l1.size()<l2.size()){
            int sub = l2.size() - l1.size();
            for (int i = 0; i < sub; i++) {
                l1.addFirst(0);
            }
        }
        int pre = 0;
        ListNode head = null;
        for (int i = l1.size()-1; i >=0; i--) {
            int val = l1.get(i)+l2.get(i);
            if (pre!=0){
                val +=pre;
            }
            pre = val/10;
            if (head==null){
                head = new ListNode(val%10);
            }else{
                ListNode node = new ListNode(val%10);
                node.next = head;
                head = node;
            }
        }
        if (pre!=0){
            ListNode node = new ListNode(pre);
            node.next = head;
            head = node;
        }
        return head;
     */
}

