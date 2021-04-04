package com.itweixiang.study.search;

import com.itweixiang.study.sort.QuickSort;

import java.util.Arrays;


public class InsertValueSearch {
    public static void main(String[] args) {
        int[] array = {-1, 2, 3, 87, 88, 99, 100, 1, 234};
        //二分查找的前提，是对一个有序的数组进行查找
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int index = search(array, 100, 0, array.length - 1);
        System.out.println(index);
    }

    public static int search(int[] array, int value, int left, int right) {
        if (left < right) {
            //差值查找是对二分查找的优化，对线性递增的数据有较好的查找效果
            int mid = left + (right - left) * (value - array[left]) / (array[right] - array[left]);
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
