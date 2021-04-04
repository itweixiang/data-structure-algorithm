package com.itweixiang.study.sort;


public class QuickSort {
    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 1, 67, 99, 0, -1};
//        int[] array = {1, 2, 3};
        int[] array = {1, 2, 1, 3, 1};
        sort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 挖坑法实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            //init为挖出来的第一个坑，位置为left
            int l = left, r = right, init = array[left];
            while (l < r) {
                while (l < r && array[r] >= init)
                    r--;
                if (l < r)
                    //将右边的值，填到left的坑中,产生新坑right
                    array[l++] = array[r];

                while (l < r && array[l] < init)
                    l++;
                if (l < r)
                    //将左边的值，填到right的坑中,产生新坑left,循环，直到剩下中间的坑
                    array[r--] = array[l];
            }
            //将初始的init填到坑中
            array[l] = init;
            sort(array, left, l - 1); // 递归调用
            sort(array, l + 1, right);
        }
    }
}
