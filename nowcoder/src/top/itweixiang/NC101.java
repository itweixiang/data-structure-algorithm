package top.itweixiang;

/**
 * 《缺失数字》
 * <p>
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 */
public class NC101 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public int solve(int[] a) {
        if(a[0]!=0) return 0;
        for (int i = 0, j = 1; i < a.length && j<a.length; i++, j++) {
            if ((a[i] + a[j]) % 2 == 0) {
                return a[i] + 1;
            }
        }
        return a[a.length-1]+1;
    }
}
