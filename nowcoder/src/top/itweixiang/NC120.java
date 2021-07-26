package top.itweixiang;

import java.math.BigInteger;

/**
 * 《二进制中1的个数》
 * <p>
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class NC120 {
    public static void main(String[] args) {
        NC120 nc120 = new NC120();
        nc120.NumberOf1(Integer.MAX_VALUE);
    }

    public int NumberOf1(int n) {
        String result = Integer.toBinaryString(n);
        int count = 0;
        String str = "";
//        while (n != 0) {
//            str = n % 2 + str;
//            n = n / 2;
//        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}
