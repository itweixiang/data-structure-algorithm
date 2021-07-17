package top.itweixiang;

/**
 * 《最长回文子串》
 * <p>
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * <p>
 * "回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 */
public class NC17 {
    /*
    "baabccc",7  result 4
    "abc1234321ab",12  result 7
    忽略了一种情况：回文串的长度不一定都是奇数，也可能是偶数，比如字符串"abba"，如果使用上面的方式判断肯定是不对的。
    TODO 重点：如果是多个字符，并且他们都是相同的，那么他们也是回文串。先要判断和他挨着的有没有相同的字符，如果有，则直接跳过。
     */
    public int getLongestPalindrome(String A, int n) {
        int max = 1;
        for (int i = 1; i < A.length() - 1; i++) {
            max = Math.max(max, getMax(A, i));
        }
        return (max << 1) + 1;
    }

    private int getMax(String a, int index) {
        int max = 0;
        int left = 1;
        int right = 1;
        while (left < index && (right + index) < a.length()) {
            if (left == 1 && a.charAt(index + right) == a.charAt(index)) {
                max++;
                right++;
                continue;
            } else if (a.charAt(index + right) == a.charAt(index - left)) {
                max++;
            } else {
                break;
            }
            left++;
            right++;
        }
        return max;
    }
}
