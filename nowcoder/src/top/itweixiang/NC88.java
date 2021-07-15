package top.itweixiang;

/**
 * 《寻找第K大》
 * <p>
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，
 * 请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
 */
public class NC88 {
    /*
    难点主要在于要应用快排的思想，快排的思想和代码实现忘了。。

    快排将数据分为两边，根据K值判断在那一边，只需递归那一边的数据直到返回就行

    题意理解也有点问题
     */
    public int findKth(int[] a, int n, int K) {
        K--;
        n--;
        return sort(a, 0, n, n-K);
    }

    public int sort(int[] a, int left, int right, int index) {
        int l = left;
        int r = right;
        //已经吧左边的第一个坑给挖了出来
        //那么在 while中，应该先遍历右边的值
        int init = a[left];
        while (l < r) {
            while (l < r && init <= a[r]) {
                r--;
            }
            if (l < r) {
                a[l] = a[r];
            }
            while (l < r && init > a[l]) {
                l++;
            }
            if (l < r) {
                a[r] = a[l];
            }
        }
        a[l] = init;
        if (index == l) {
            return a[l];
        } else if (l > index) {
            return sort(a, left, l - 1, index);
        } else {
            return sort(a, l + 1, right, index);
        }
    }
}
