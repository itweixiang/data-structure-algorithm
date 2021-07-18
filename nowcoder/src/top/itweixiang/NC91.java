package top.itweixiang;

import java.util.*;

/**
 * 《最长递增子序列》
 * <p>
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。
 * （如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
 */
public class NC91 {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 0, 6, 2, 9, 3};
        NC91 nc91 = new NC91();
        int[] lis = nc91.LIS(arr);
    }

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        if (arr.length == 0) return null;
        if (arr.length == 1) return arr;
        ArrayList<LinkedList<Integer>> list = new ArrayList<>();
        int[] maxArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (list.isEmpty()) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(val);
                list.add(linkedList);
                maxArr[0] = val;
            } else {
                for (int j = 0; j < list.size(); j++) {
                    LinkedList<Integer> linkedList = list.get(j);
                    if (j - 1 >= 0 && (maxArr[j - 1] + val) < maxArr[j]) {
                        LinkedList<Integer> copy = new LinkedList<>(list.get(j));
                        copy.add(val);
                        list.set(j, copy);
                    } else if (linkedList.peekLast() > val) {
                        Integer pop = linkedList.pop();
                        if (linkedList.isEmpty()) {
                            int min = Math.min(pop, val);
                            linkedList.add(min);
                            maxArr[j] = min;
                        } else if (linkedList.peekLast() < val) {
                            linkedList.add(val);
                            maxArr[j] = maxArr[j] - pop + val;
                        } else {
                            linkedList.add(pop);
                        }
                    } else if (linkedList.peekLast() < val) {
                        LinkedList<Integer> copy = new LinkedList<>(list.get(j));
                        copy.add(val);
                        list.add(copy);
                        maxArr[j] = maxArr[j] + val;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 最长递增子序列的长度
     *
     * @param arr
     * @return
     */
    public int maxLength(int[] arr) {
        int[] length = new int[arr.length];
        for (int i = 0; i < length.length; i++) {
            length[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < val) {
                    length[i] = length[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < length.length; i++) {
            max = Math.max(length[i], max);
        }
        return max;
    }

}