package top.itweixiang;

import java.util.Arrays;

/**
 * 《合并两个有序的数组》
 * 给出一个整数数组A和有序的整数数组B，请将数组B合并到数组A中，变成一个有序的升序数组
 * 注意：
 * 1.可以假设A数组有足够的空间存放B数组的元素，A和B中初始的元素数目分别为m和n ，
 * A 的数组空间大小为 m+n
 * 2.不要返回合并的数组，返回是空的，将数组B的数据合并到A里面就好了
 * 3.A数组在[0,m-1]的范围也是有序的
 * <p>
 * 例1:
 * A: [1,2,3,0,0,0]，m=3
 * B: [2,5,6]，n=3
 * 合并过后A为:
 * A: [1,2,2,3,5,6]
 */
public class NC22 {
    /*
    比较符合直觉的，应该是插入排序，但是需要维护后续的一些值，所以直接用二分排序了。。
     */
public void merge(int A[], int m, int B[], int n) {
    m--;
    n--;
    for (int i = 0; i < A.length; i++) {
        //睡醒的时候想到了，从尾巴开始，把最大的数放进去
        if (n >= 0 && (m < 0 || B[n] > A[m])) {
            A[A.length - 1 - i] = B[n--];
        } else {
            A[A.length - 1 - i] = A[m--];
        }
    }
}
    /*
    这么处理，其实不太好
    for (int i = 0; i < n; i++) {
        int b = B[i];
        A[m + b] = b;
    }
    Arrays.sort(A);
     */
}
