package top.itweixiang;

/**
 * 《跳台阶》
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class NC68 {
    public int jumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target - 1];
    }
}
