package top.itweixiang.study.sort;


public class InsertSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 67, 99, 0, -1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            if (i != 0 && newArray[i - 1] > array[i]) {
                for (int j = i; j > 0; j--) {
                    if (newArray[j - 1] > newArray[j]) {
                        int temp = newArray[j];
                        newArray[j] = newArray[j - 1];
                        newArray[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }
}
