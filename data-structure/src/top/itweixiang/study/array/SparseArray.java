package top.itweixiang.study.array;

/**
 * 稀疏数组
 * 当元素大量为同一个值时，可以考虑用稀疏数组来压缩数据
 * <p>
 * 稀疏数组和原始二维数组等，可以互相转换
 */
public class SparseArray {
    /**
     * 五子棋案例
     *
     * @param args
     */
    public static void main(String[] args) {
        //创建一个原始的二维数组，0表示五子，1表示黑子，2表示白子
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][1] = 2;
        //打印
        printQrArray(chessArray);

        int[][] sparseArray = toSparseArray(chessArray);

        printQrArray(sparseArray);

        int[][] sourceArray = toSourceArray(sparseArray);

        printQrArray(sourceArray);
    }

    public static void printQrArray(int[][] qrArray) {
        for (int[] ints : qrArray) {
            for (int anInt : ints) {
                System.out.printf(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] toSourceArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] sourceArray = new int[row][col];

        for (int i = 1; i < sparseArray.length; i++) {
            int[] array = sparseArray[i];
            sourceArray[array[0]][array[1]] = array[2];
        }

        return sourceArray;
    }

    public static int[][] toSparseArray(int[][] qrArray) {
        //遍历数组，得到非零数据的个数
        int count = 0;
        for (int[] ints : qrArray) {
            for (int i : ints) {
                if (i != 0) {
                    count++;
                }
            }
        }
        //稀疏数组，第一行默认存原数组的行数，列树，和有效数据的个数
        //所以数组的大小要+1
        //稀疏数组的第二位，需要存三个数据，原数组的行，列，值
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = qrArray.length;
        sparseArray[0][1] = qrArray[0].length;
        sparseArray[0][2] = count;

        //稀疏数组赋值
        int index = 1;
        for (int i = 0; i < qrArray.length; i++) {
            int[] array = qrArray[i];
            for (int j = 0; j < array.length; j++) {
                int k = array[j];
                if (k != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = k;
                    index++;
                }
            }
        }
        return sparseArray;
    }
}
