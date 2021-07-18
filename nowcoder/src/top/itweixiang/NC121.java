package top.itweixiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 《字符串的排列》
 * <p>
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class NC121 {
    public static void main(String[] args) {
        NC121 nc121 = new NC121();
        nc121.Permutation("aabc");
    }

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            char[] copy = str.toCharArray();
            char tmp = copy[0];
            copy[0] = copy[i];
            copy[i] = tmp;
            set.add(String.valueOf(copy));
            for (int j = 1; j < chars.length; j++) {
                for (int k = j; k < chars.length; k++) {
                    set.add(extracted(set, j, copy, k));
                }
            }

        }

        return new ArrayList<>(set);
    }

    private String extracted( TreeSet<String> set, int current, char[] copy, int swap) {
        char[] co = Arrays.copyOf(copy, copy.length);
        char tm = co[current];
        co[current] = co[swap];
        co[swap] = tm;
        return String.valueOf(co);
    }


}
