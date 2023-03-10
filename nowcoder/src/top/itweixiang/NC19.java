package top.itweixiang;


/**
 * 《子数组的最大累加和问题》
 * <p>
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class NC19 {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        maxsumofSubarray(arr);
    }

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxsumofSubarray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
