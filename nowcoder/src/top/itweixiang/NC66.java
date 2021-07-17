package top.itweixiang;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 《两个链表的第一个公共结点》
 * <p>
 * 输入两个无环的单链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class NC66 {
    /*
    另外一种解题方式为双指针法，同时遍历两个链表，若节点值相同，则为公关节点
    但是两个链表的长度不相同
    假设链表1 长度为a  链表2 长度为b
    a + b = b + a
    两个链表相加得出另外两个链表，对新的两边进行遍历
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = pHead1;
        while (tmp != null) {
            set.add(tmp);
            tmp = tmp.next;
        }
        tmp = pHead2;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
