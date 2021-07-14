package top.itweixiang;

import java.util.Stack;

/**
 * 《最长括号子串》
 * <p>
 * 给出一个仅包含字符'('和')'的字符串，计算最长的格式正确的括号子串的长度。
 * 对于字符串"(()"来说，最长的格式正确的子串是"()"，长度为2.
 * 再举一个例子：对于字符串")()())",来说，最长的格式正确的子串是"()()"，长度为4.
 */
public class NC49 {
    /**
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int length = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            String ss = String.valueOf(chars[i]);
            if ("(".equals(ss)) {
                //记录索引的位置。。
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // 新的子串生成完，记录下一串子串的初始位置
                    last = i;
                } else {
                    stack.pop();
                    length = stack.isEmpty()
                            // 为空的话，说明当前串已经完结，计算长度
                            ? Math.max(length, i - last)
                            // 不为空，与上一个符号计算长度
                            : Math.max(length, i - stack.peek());
                }
            }
        }

        return length;
    }
    /*
    public int longestValidParentheses(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int length = 0;
        int currentLength = 0;
        for (int i = 0; i < chars.length; i++) {
            String ss = String.valueOf(chars[i]);
            if ("(".equals(ss)) {
                todo 这里记录括号根本没必要，因为塞进去的，都是(
                stack.push("(");
            } else if (")".equals(ss) && !stack.isEmpty()) {
                (((()((()
                todo 很难判断，栈中( 对后续 )的影响，很容易就取错值
                stack.pop();
                currentLength += 2;
            } else if (currentLength > length) {
                length = currentLength;
                currentLength = 0;
            }
        }
        return length;
    }
    */
}

