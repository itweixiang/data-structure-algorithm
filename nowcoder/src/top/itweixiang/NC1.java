package top.itweixiang;

import java.util.Stack;

/**
 * 《大数加法》
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class NC1 {
    public static void main(String[] args) {
        NC1 nc1 = new NC1();
        nc1.solve("1234", "12349");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        StringBuilder str = new StringBuilder();
        int tmp = 0;
        int sLength = s.length(), tLength = t.length();
        while (sLength != 0 || tLength != 0 || tmp != 0) {
            Integer i1 = sLength < 1 ? 0 : Integer.valueOf(String.valueOf(s.charAt(--sLength)));
            Integer i2 = tLength < 1 ? 0 : Integer.valueOf(String.valueOf(t.charAt(--tLength)));
            str = str.insert(0, (i1 + i2 + tmp) % 10);
            tmp = (i1 + i2 + tmp) / 10;
        }
        return str.toString();
    }
}
