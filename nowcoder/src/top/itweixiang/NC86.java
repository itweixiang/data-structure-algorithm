package top.itweixiang;

import java.util.Random;

/**
 * 《矩阵元素查找》
 * <p>
 * 已知int一个有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，且矩阵的行和列都是从小到大有序的。
 * 设计查找算法返回所查找元素的二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 */
public class NC86 {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        NC86 nc86 = new NC86();
        int[] element = nc86.findElement(arr, 3, 3, 5);
        System.out.println(element[0] + "-" + element[1]);

//        int[][] arr = new int[50][50];
//        for (int i = 0; i < 50; i++) {
//            arr[i][0] = new Random().nextInt(1000);
//            System.out.print("{");
//            for (int j = 1; j < 50; j++) {
//                arr[i][j] = arr[i][j - 1] + new Random().nextInt(1000);
//                if (j != 49) {
//                    System.out.print(arr[i][j] + ",");
//                }else {
//                    System.out.print(arr[i][j] );
//                }
//            }
//            System.out.println("},");
//        }

    }

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int row = 0;
        int col = m - 1;
        int[] res = new int[2];

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                res[0] = row;
                res[1] = col;
                break;
            } else if (mat[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return res;
    }

}
