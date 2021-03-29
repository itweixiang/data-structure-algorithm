package com.itweixiang.study.sort;

public class SelectInsert {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 67, 99, 0, -1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    index = j;
                    min = array[j];
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
