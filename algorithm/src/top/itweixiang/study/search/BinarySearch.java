package top.itweixiang.study.search;

import top.itweixiang.study.sort.QuickSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-1, 2, 3, 87, 88, 99, 100, 1, 234};
        //二分查找的前提，是对一个有序的数组进行查找
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int index = search(array, 101, 0, array.length - 1);
        System.out.println(index);
    }

    public static int search(int[] array, int value, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            if (array[mid] > value) {
                return search(array, value, left, mid);
            } else if (array[mid] < value) {
                return search(array, value, mid + 1, right);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}
