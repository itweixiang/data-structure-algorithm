package top.itweixiang;

import java.util.HashMap;

/**
 * 《数组中出现次数超过一半的数字》
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
 * <p>
 * 1：使用map存储最大数
 * 2：对数组进行排序，取中间的数
 * 3：遍历数组，消去不相等的数，取剩余的数
 */
public class NC73 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if(array.length==1) return array[0];
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int val = array[i];
            if (map.containsKey(val)) {
                Integer count = map.get(val);
                count++;
                if (count > array.length/2) {
                    return val;
                } else {
                    map.put(val, count);
                }
            } else {
                map.put(val, 1);
            }
        }
        return -1;
    }
}
