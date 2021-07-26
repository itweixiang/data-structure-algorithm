package top.itweixiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 《加起来和为目标值的组合》
 */
public class NC46 {

    public static void main(String[] args) {
        NC46 nc46 = new NC46();
        int[] nums = {2, 3};
        nc46.combinationSum2(nums, 5);
    }

ArrayList<ArrayList<Integer>> result = new ArrayList<>();
HashSet<String> set = new HashSet<>();

public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    Arrays.sort(num);
    cal(num, target, 0, new ArrayList<>());
    return result;
}

private void cal(int[] num, int target, int current, ArrayList<Integer> list) {
    if (current < num.length && num[current] > target) return;
    for (int i = current; i < num.length; i++) {
        if (num[i] == target) {
            list.add(num[i]);
            if (!set.contains(list.toString())) {
                result.add(new ArrayList<>(list));
                set.add(list.toString());
            }
            return;
        } else if (num[i] < target) {
            list.add(num[i]);
            cal(num, target - num[i], i + 1, new ArrayList<>(list));
            list.remove(list.size() - 1);
        } else {
            break;
        }
    }
}
}
