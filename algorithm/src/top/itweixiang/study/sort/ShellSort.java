package top.itweixiang.study.sort;

public class ShellSort {
    public static void main(String[] args) {
//        int[] array = {1, 2, 4, 1, 67, 0, -1};
        int[] array = {1, 2, 3, 87, 87, 99, 100, 1, 234};
//        int[] array = {1, 2, 1, 3, 1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] array) {
        int incr = array.length;
        int temp;

        while (true) {
            //步长
            incr = incr / 2;
            //分成几组
            for (int i = incr; i < array.length; i++) {
                //每组中的元素从尾部进行比较
                for (int j = i - incr; j >= 0; j -= incr) {
                    if (array[j] > array[j + incr]) {
                        temp = array[j];
                        array[j] = array[j + incr];
                        array[j + incr] = temp;
                    }
                }
            }
            if (incr == 1) {
                break;
            }
        }
    }
}
