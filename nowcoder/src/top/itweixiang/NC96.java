package top.itweixiang;

/**
 * 《判断一个链表是否为回文结构》
 * <p>
 * 给定一个链表，请判断该链表是否为回文结构。
 * [1,2,2,1] true
 */
public class NC96 {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    /*
     如果构造一个数据结构，用以定位，则空间复杂度变高。
     如果计算中间节点或者尾部节点，则时间复杂度较高。
     在计算中间节点或者尾部节点的过程中，使用快慢指针用以优化
     */
    public boolean isPail(ListNode head) {
        if (head.next == null) return true;
        ListNode middle = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }
        ListNode tail = reverse(middle);
        while (tail != null) {
            if (tail.val != head.val) {
                return false;
            } else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode start) {
        ListNode head = start;
        while (head.next != null) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
