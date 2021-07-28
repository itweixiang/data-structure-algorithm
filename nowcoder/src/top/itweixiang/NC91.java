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
        int[] arr = {1, 3, 8, 6, 5, 2};
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
        //每一项子序列的长度
        int[] nums = new int[arr.length];
        int[] temp = new int[arr.length];
        nums[0] = 1;
        int tempIndex = 0;
        temp[tempIndex] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            int left = 0, right = tempIndex;
            if (arr[i] > temp[tempIndex]) {
                ++tempIndex;
                nums[i] = tempIndex + 1;
                temp[tempIndex] = arr[i];
            } else {
                // 注意这里 left <= right 而不是 left < right，我们要替换的是第一个比 arr[i] 大的元素
                while (left <= right) {
                    int mid = (right + left) / 2;
                    if (temp[mid] >= arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                temp[left] = arr[i];
                nums[i] = left + 1;
            }
        }

        int[] res = new int[tempIndex + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == tempIndex + 1) {
                res[tempIndex] = arr[i];
                --tempIndex;
            }
        }
        return res;
    }
    /*
        //todo 自己写的代码2.0版本，但还是没过，很尴尬嘿嘿

        if (arr.length == 1) return arr;
        int[] lengthArr = new int[arr.length];
        int[] maxArr = new int[arr.length];
        //最开始，每个
        for (int i = 0; i < arr.length; i++) {
            maxArr[i] = arr[i];
        }
        //记录最大长度
        //计算子序列长度和对应的最大值
        int maxLength = 0;
        // todo 这个循环的时间复杂度太高
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // 记录长度
                    lengthArr[i] = lengthArr[j] + 1;
                    // 记录和大小，只记录最小的和
                    if (maxArr[i] == arr[i] || maxArr[i] > maxArr[j] + arr[i]) {
                        maxArr[i] = maxArr[j] + arr[i];
                    }
                    maxLength = Math.max(maxLength, lengthArr[i]);
                }
            }
        }
        //获取和最小的子序列索引
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = lengthArr.length - 1; i >= 0; i--) {
            if (lengthArr[i] == maxLength && maxArr[i] < min) {
                index = i;
                min = maxArr[i];
            }
        }
        // 填充数据
        int[] result = new int[maxLength + 1];
        result[maxLength] = arr[index];
        int last = index;
        while (maxLength > 0) {
            if (arr[index] < arr[last]) {
                result[--maxLength] = arr[index];
                last = index;
            }
            index--;
        }

        return result;
     */

    /**
     * retrun the longest increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
//    todo 错误的答案，自己没有做出来，即使做出来，用动态规划的算法也会超时，哭了
//    public int[] LIS(int[] arr) {
//        if (arr.length == 1) return arr;
//        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(arr[0]);
//        map.put(0, linkedList);
//
//        ArrayList<Integer> maxList = new ArrayList<>();
//        maxList.add(arr[0]);
//
//        for (int i = 1; i < arr.length; i++) {
//            int val = arr[i];
//            for (int j = 0; j < map.size(); j++) {
//                LinkedList<Integer> value = map.get(j);
//                if (value.peekLast() < val) {
//                    if (!map.containsKey(j + 1)) {
//                        j++;
//                        LinkedList<Integer> copy = new LinkedList<>(value);
//                        copy.add(val);
//                        map.put(j, copy);
//                        maxList.add(j, maxList.get(j - 1) + val);
//                    } else if (j + 1 < map.size() && maxList.get(j) + val < maxList.get(j + 1)) {
//                        //  是否晋级
//                        LinkedList<Integer> copy = new LinkedList<>(value);
//                        copy.add(val);
//                        map.put(j + 1, copy);
//                        maxList.set(j + 1, maxList.get(j) + val);
//                        j++;
//                    }
//                } else {
//                    Integer tmp = value.pollLast();
//                    if (value.isEmpty() || value.peekLast() < val) {
//                        value.add(val);
//                        maxList.set(j, maxList.get(j) - tmp + val);
//                    } else {
//                        // 该数不能加进来
//                        value.add(tmp);
//                    }
//                }
//            }
//        }
//        LinkedList<Integer> result = map.get(map.size() - 1);
//        int[] re = new int[result.size()];
//        int i = 0;
//        while (!result.isEmpty()) {
//            re[i] = result.pollFirst();
//            i++;
//        }
//        return re;
//    }

    /**
     * 最长递增子序列的长度
     *
     * @param arr
     * @return
     */
    public int maxLength(int[] arr) {
        int[] length = new int[arr.length];
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
        return max + 1;
    }

}