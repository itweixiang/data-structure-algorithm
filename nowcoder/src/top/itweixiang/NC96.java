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
        ListNode node = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            node = node.next;
            fast = fast.next.next;
        }
        Boolean flag = Boolean.TRUE;
        while (node != null && flag == true) {
            if (node.val != head.val) {
                flag = false;
                break;
            }
            node = node.next;
            head = head.next;
        }
        return flag;
    }
}
