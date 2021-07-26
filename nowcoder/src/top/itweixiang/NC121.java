package top.itweixiang;

import java.util.ArrayList;
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
        TreeSet<String> treeSet = new TreeSet<>();
        cal(treeSet, str, "");
        return new ArrayList<>(treeSet);
    }

    public void cal(TreeSet<String> set, String str, String ss) {
        if (str.length() == 1) {
            set.add(ss + str);
        } else {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                cal(set, str.substring(0, i) + str.substring(i + 1, str.length()), ss + chars[i]);
            }
        }
    }

}
