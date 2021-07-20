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
        int[] arr = {7, 123113, 7, -1, 8};
        NC91 nc91 = new NC91();
        int[] lis = nc91.LIS(arr);
    }
    /*
    第一步——求最长递增子序列长度
    第二步——求字典序靠前的子序列

    贪心+二分的解法，举例说明基本思路，假设数组arr为[2, 3, 1, 2, 3]，
    vec数组里面存放递增子序列，maxLen数组里存放以元素i结尾的最大递增子序列长度，那么遍历数组arr并执行如下更新规则:

    初始情况下，vec为[2]，maxLen[1]
    接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[2,3]，maxLen[1,2]
    接下来遇到1，由于vec最后的元素大于1, 我们在vec中查找大于等于1的第一个元素的下标，并用1替换之，此时vec为[1,3], maxLen[1,2,1]
    接下来遇到2，由于vec最后的元素大于2，我们在vec中查找大于等于2的第一个元素的下标，并用2替换之，此时vec为[1,2], maxLen[1,2,1,2]
    接下来遇到3，由于vec最后一个元素小于3，直接更新，vec为[1,2,3]，maxLen为[1,2,1,2,3]
    此时vec的大小就是整个序列中最长递增子序列的长度（但是vec不一定是本题的最终解）

    对于第二步，假设我们原始数组是arr1，得到的maxLen为[1,2,3,1,3]，最终输出结果为res（字典序最小的最长递增子序列），
    res的最后一个元素在arr1中位置无庸置疑是maxLen[i]==3对应的下标，那么到底是arr1[2]还是arr1[4]呢？如果是arr1[2]，
    那么arr1[2]<arr1[4]，则maxLen[4]==4，与已知条件相悖。因此我们应该取arr1[4]放在res的最后一个位置。
    vector<int> LIS(vector<int>& arr) {
        // write code here
        // 第一步：利用贪心+二分求最长递增子序列长度
        vector<int> res;
        vector<int> maxLen;
        if (arr.size() < 1) return res;
        res.emplace_back(arr[0]);  // 注：emplace_back(val)作用同push_back，效率更高
        maxLen.emplace_back(1);
        for (int i = 1; i < arr.size(); ++i) {
            if (arr[i] > res.back()) {
                res.emplace_back(arr[i]);
                maxLen.emplace_back(res.size());
            } else {
                // lower_bound(begin, end, val)包含在<algorithm>中
                // 它的作用是返回有序数组begin..end中第一个大于等于val的元素的迭代器
                int pos = lower_bound(res.begin(), res.end(), arr[i]) - res.begin();
                res[pos] = arr[i];
                maxLen.emplace_back(pos+1);
            }
        }
        // 第二步：填充最长递增子序列
        for (int i = arr.size()-1, j = res.size(); j > 0; --i) {
            if (maxLen[i] == j) {
                res[--j] = arr[i];
            }
        }
        return res;
    }
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