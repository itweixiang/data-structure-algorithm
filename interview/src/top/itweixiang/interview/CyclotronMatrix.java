package top.itweixiang.interview;

/**
 * 回旋矩阵
 * 示例：
 * 输入 2，输出：
 * 1   2
 * 4   3
 * 输入 3，输出：
 * 1   2   3
 * 8   9   4
 * 7   6   5
 */
public class CyclotronMatrix {
    public static void main(String[] args) {
        int[][] arrays = new int[5][5];
        arrays[0][0] = 1;
        int last = arrays[0][0];
        // fill 方向，1左，2下，3右，4上
        fill(last, 1, 0, 0, arrays);
        for (int[] array : arrays) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void fill(int last, int direct, int xindex, int yindex, int[][] arrays) {
        if (direct == 1) {
            if (arrays[xindex][++yindex] != 0) {
                return;
            }
            while (yindex < arrays.length) {
                if (arrays[xindex][yindex] != 0) {
                    break;
                }
                arrays[xindex][yindex] = ++last;
                last = arrays[xindex][yindex++];
            }
            fill(last, 2, xindex, --yindex, arrays);
        }
        if (direct == 2) {
            if (arrays[++xindex][yindex] != 0) {
                return;
            }
            while (xindex < arrays.length) {
                if (arrays[xindex][yindex] != 0) {
                    break;
                }
                arrays[xindex][yindex] = ++last;
                last = arrays[xindex++][yindex];
            }
            fill(last, 3, --xindex, yindex, arrays);
        }
        if (direct == 3) {
            if (arrays[xindex][--yindex] != 0) {
                return;
            }
            while (yindex >= 0) {
                if (arrays[xindex][yindex] != 0) {
                    break;
                }
                arrays[xindex][yindex] = ++last;
                last = arrays[xindex][yindex--];
            }
            fill(last, 4, xindex, ++yindex, arrays);
        }
        if (direct == 4) {
            if (arrays[--xindex][yindex] != 0) {
                return;
            }
            while (xindex >= 0) {
                if (arrays[xindex][yindex] != 0) {
                    break;
                }
                arrays[xindex][yindex] = ++last;
                last = arrays[xindex--][yindex];
            }
            fill(last, 1, ++xindex, yindex, arrays);
        }
    }
}
