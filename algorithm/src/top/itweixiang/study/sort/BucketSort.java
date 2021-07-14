package top.itweixiang.study.sort;


/**
 * 桶排序也叫做基数排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 1};

        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }


    public static void sort(int[] arr) {
        // 取最大数的长度 = 需要装入桶的次数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();

        // 数据桶
        int[][] bucket = new int[10][arr.length];

        // 每个桶的当前索引
        int[] bucketIndex = new int[10];
        // 循环每一位数
        for (int i = 0, m = 1; i < maxLength; i++, m *= 10) {
            // 循环每个元素 放入桶中
            for (int k = 0; k < arr.length; k++) {
                // 取基数
                int radix = arr[k] / m % 10;
                // 将基数存取到对应的桶中
                bucket[radix][bucketIndex[radix]++] = arr[k];
            }
            // 排完之后放回原数组中，然后继续排
            int arrIndex = 0;
            for (int b = 0; b < bucket.length; b++) {
                for (int bi = 0; bi < bucketIndex[b]; bi++) {
                    arr[arrIndex++] = bucket[b][bi];
                }
                bucketIndex[b] = 0;
            }
        }
    }
}
