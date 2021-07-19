package top.itweixiang;

/**
 * 《判断回文》
 * <p>
 * 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
 */
public class NC141 {
    public static void main(String[] args) {
        NC141 nc141 = new NC141();
        nc141.judge("aba");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge(String str) {
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if (str.length() / 2 == i) break;
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return Boolean.TRUE;
    }
}
