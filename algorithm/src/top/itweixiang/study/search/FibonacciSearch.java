package top.itweixiang.study.search;

import top.itweixiang.study.sort.QuickSort;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {-1, 2, 3, 87, 88, 99, 100, 1, 234};
        //二分查找的前提，是对一个有序的数组进行查找
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int index = search(array, 234);
        System.out.println(index);
    }

    public static int search(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        //斐波那契分割数值的下标
        int k = 0;
        int mid = 0;
        int[] fibArray = fib();
        //获取斐波那契的分割值
        while (high > fibArray[k] - 1) {
            k++;
        }
        //f[k]的值，可能大于数组的长度，最大值填充
        int[] temp = Arrays.copyOf(array, fibArray[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }
        while (low <= high) {
            //f(n) = f(n-1) + f(n-2)
            //f(n)-1 = (f(n-1)-1) + (f(n-2)-1) + 1
            mid = low + fibArray[k - 1] - 1;
            if (value < temp[mid]) {
                high = mid - 1;
                k -= 1;
            } else if (value > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    /**
     * 构造一个斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 20; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

}
