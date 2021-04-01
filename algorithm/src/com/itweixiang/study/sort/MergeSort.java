package com.itweixiang.study.sort;

/**
 * 尽量把复杂的逻辑细分
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 1, 67, 0, -1};
        int[] array = {1, 2, 3, 87, 87, 99, 100, 1, 234};
//        int[] array = {1, 2, 1, 3, 1};
        sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        //先把左右两边的数据，依次有序填充到temp中，直到一边无数据
        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                temp[index++] = array[l++];
            } else {
                temp[index++] = array[r++];
            }
        }

        //将两边剩余的数据填充到temp中
        while (l <= mid) {
            temp[index++] = array[l++];
        }
        while (r <= right) {
            temp[index++] = array[r++];
        }

        //将temp拷贝到array
        for (int j = left, i = 0; j <= right; j++, i++) {
            array[j] = temp[i];
        }
    }

}
