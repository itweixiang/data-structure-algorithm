package top.itweixiang;

/**
 * 1、迭代反转，逻辑简单，变量控制复杂
 * 2、递归反转，逻辑简单，代码简单，但是递归控制复杂
 * 3、头插法反转，目前使用
 * 4、就地逆置法反转，逻辑简单，与头插法类似，把节点摘出来当做头结点
 */
public class NC78 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ReverseList(head1);
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode newhead = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newhead;
            newhead = tmp;
        }
        head = newhead;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}