package top.itweixiang;

import java.util.*;

/**
 * 《最小的K个数》
 * <p>
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 0 <= k <= input.length <= 10000
 * 0 <= input[i] <= 10000
 */
public class NC119 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        // 构造一个有序 重复的数组，并维护好里面的值
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int in = input[i];
            if (list.size() < k) {
                list.add(in);
            } else {
                if (!list.isEmpty() && list.get(k - 1) > in) {
                    list.set(k - 1, in);
                    Collections.sort(list);
                }
            }
        }
        return list;
    }
}
