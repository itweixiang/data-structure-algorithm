package top.itweixiang;

/**
 * 《接雨水问题》
 * <p>
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class NC128 {
    public static void main(String[] args) {
        NC128 nc128 = new NC128();
        int[] arr = {10, 1, 1, 10, 1, 1, 10, 1, 1, 10};
        nc128.maxWater(arr);
    }

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return 0L;
        int maxIndex = 0;
        //存在越界
        long sum = 0L;
        long count = 0L;
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[left] > arr[i]) {
                count = count + arr[maxIndex] - arr[i];
            } else {
                sum += count;
                maxIndex = i;
                left = i;
                count = 0;
            }
        }
        // 累和重置
        count = 0;
        int right = arr.length - 1;
        for (int i = arr.length - 2; i >= maxIndex; i--) {
            if (arr[right] > arr[i]) {
                count = count + arr[right] - arr[i];
            } else {
                right = i;
                sum += count;
                count = 0;
            }
        }
        return sum;
    }
}
