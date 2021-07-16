package top.itweixiang;

/**
 * 《最长公共子串》
 * <p>
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 */
public class NC127 {
    public static void main(String[] args) {
        LCS("1AB2345CD","12345EF");
    }

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
public static String LCS(String str1, String str2) {
    int[][] arr = new int[str1.length()][str2.length()];
    int start = 0, end = 0, max = 0;
    for (int i = 0; i < str1.length(); i++) {
        for (int j = 0; j < str2.length(); j++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                arr[i][j] = 1;
            } else {
                arr[i][j] = 0;
            }
        }
    }

    for (int i = 0; i < str1.length(); i++) {
        for (int j = 0; j < str2.length(); j++) {
            if (arr[i][j] == 1) {
                int m = 1, ii = i + 1, jj = j + 1;
                while (ii < str1.length() && jj < str2.length()) {
                    if (arr[ii][jj] == 1) {
                        m++;
                        ii++;
                        jj++;
                    } else {
                        break;
                    }
                }
                if (m > max) {
                    start = i;
                    end = ii;
                    max = m;
                }
            }
        }
    }
    return str1.substring(start, end);
}
}
