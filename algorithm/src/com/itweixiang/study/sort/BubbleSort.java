package com.itweixiang.study.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 67, 99, 0, -1};
        sort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    public static void sort(int[] array) {
        //剩自己了就没有必要比较了
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
