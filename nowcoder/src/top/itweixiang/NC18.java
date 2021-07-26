package top.itweixiang;

/**
 * 《顺时针旋转矩阵》
 * <p>
 * 有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。
 * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300
 */
public class NC18 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NC18 nc18 = new NC18();
        nc18.rotateMatrix(mat, 3);
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        if (n == 0) return mat;
        int[][] m = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] vals = mat[i];
            for (int j = 0; j < vals.length; j++) {
                m[j][mat.length - i - 1] = mat[i][j];
            }
        }
        return m;
    }
}
