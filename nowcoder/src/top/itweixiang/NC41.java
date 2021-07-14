package top.itweixiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 《 最长无重复子数组》
 * <p>
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 */
public class NC41 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 2, 2};
        System.out.println(maxLength(arr));
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    /*
    该解法类似于队列
    public int maxLength(int[] arr) {
        //用链表实现队列，队列是先进先出的
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int c : arr) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
     */
    public static int maxLength(int[] arr) {
        int length = 0;
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (tmp.contains(a)) {
                length = Math.max(tmp.size(), length);
                List<Integer> newtmp = tmp.subList(tmp.lastIndexOf(a) + 1, tmp.size());
                // 去掉原先 第一个a , 生成一个没有a的子串，这个子串有可能与后续的数字生成更长的子串
                tmp = newtmp;
            }
            tmp.add(a);
            length = Math.max(tmp.size(), length);
        }
        return length;
    }

    /*
    int length = 0;
    ArrayList<Integer> tmp = new ArrayList<>();

    todo 遇到的问题 1234526789
    12345 断了
    但
    34526789才是最长的

    for (int i = 0; i < arr.length; i++) {
        int a = arr[i];
        if (tmp.contains(a)) {
            length = Math.max(tmp.size(), length);
            tmp.clear();
        }
        tmp.add(a);
        length = Math.max(tmp.size(), length);

    }
    return length;
    */
}