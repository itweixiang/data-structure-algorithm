package top.itweixiang;

/**
 * 《链表的奇偶重排》
 * <p>
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 */
public class NC133 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode ji = null;
        ListNode ou = null;
        ListNode jiTmp = null;
        ListNode ouTmp = null;
        ListNode tmp = head;
        int count = 1;
        while (tmp != null) {
            if (count % 2 == 0) {
                if (ou == null) {
                    ou = new ListNode(tmp.val);
                    ouTmp = ou;
                } else {
                    ouTmp.next = new ListNode(tmp.val);
                    ouTmp = ouTmp.next;
                }
            } else {
                if (ji == null) {
                    ji = new ListNode(tmp.val);
                    jiTmp = ji;
                } else {
                    jiTmp.next = new ListNode(tmp.val);
                    jiTmp = jiTmp.next;
                }
            }
            count++;
            tmp = tmp.next;
        }
        jiTmp.next = ou;
        return ji;
    }
}
