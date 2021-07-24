package top.itweixiang;

/**
 * 《矩阵的最小路径和》
 * <p>
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 */
public class NC59 {
    public static void main(String[] args) {
        NC59 nc59 = new NC59();
        int[][] arr = {{1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}};
        nc59.minPathSum(arr);
    }

    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        arr[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            arr[i][0] = matrix[i][0] + arr[i - 1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            arr[0][i] = matrix[0][i] + arr[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    arr[i][j] = arr[i][j - 1] + matrix[i][j];
                } else {
                    arr[i][j] = arr[i - 1][j] + matrix[i][j];
                }
            }
        }

        return arr[matrix.length - 1][matrix[0].length - 1];
    }
}
