package top.itweixiang;

/**
 * 《合并有序链表》
 * <p>
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class NC33 {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode headTmp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    headTmp = l1;
                } else {
                    headTmp.next = l1;
                    headTmp = headTmp.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    headTmp = l2;
                } else {
                    headTmp.next = l2;
                    headTmp = headTmp.next;
                }
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            if (head == null) {
                head = l1;
                headTmp = l1;
            } else {
                headTmp.next = l1;
                headTmp = headTmp.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            if (head == null) {
                head = l2;
                headTmp = l2;
            } else {
                headTmp.next = l2;
                headTmp = headTmp.next;
            }
            l2 = l2.next;
        }
        return head;
    }
}
