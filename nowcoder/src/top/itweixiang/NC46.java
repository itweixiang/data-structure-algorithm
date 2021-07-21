package top.itweixiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 《加起来和为目标值的组合 》
 */
public class NC46 {
    public static void main(String[] args) {
        NC46 nc46 = new NC46();
        int[] nums = {100, 10, 20, 70, 60, 10, 50};
        nc46.combinationSum2(nums, 80);
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            list.addLast(num[i]);
        }
        ArrayList<Integer> tmpList = new ArrayList<>();
        int tmp = target;
        while (!list.isEmpty()) {
            if (list.peekFirst() > tmp) {
                for (int i = tmpList.size() - 1; i >= 0; i++) {
                    list.addFirst(tmpList.get(i));
                    tmp = target;
                }
                //第一个元素不要了
                list.pollFirst();
            } else {
                Integer i = list.pollFirst();
                tmp = tmp - i;
                if (tmp == 0) {
                    result.add(new ArrayList<>(tmpList));
                    tmpList.clear();
                } else {
                    tmpList.add(i);
                }
            }
        }
        return result;
    }
}
