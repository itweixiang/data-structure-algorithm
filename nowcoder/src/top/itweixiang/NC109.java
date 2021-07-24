package top.itweixiang;

/**
 * 《岛屿数量》
 * <p>
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 */
public class NC109 {
    public static void main(String[] args) {
        NC109 nc109 = new NC109();
        char[][] chars = {
                {'1', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        nc109.solve(chars);
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                } else {
                    search(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public void search(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        if (y >= 1) {
            search(grid, x, y - 1);
        }
        if (x <= grid.length - 2) {
            search(grid, x + 1, y);
        }
        if (y <= grid[0].length - 2) {
            search(grid, x, y + 1);
        }
        if (x >= 1) {
            search(grid, x - 1, y);
        }
    }
}
