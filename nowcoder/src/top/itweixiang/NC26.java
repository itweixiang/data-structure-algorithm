package top.itweixiang;

import java.util.ArrayList;

/**
 * 《括号生成》</>
 * <p>
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 */
public class NC26 {
    /**
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> arrayList = new ArrayList<>();
        backTrace("", 0, 0, n, arrayList);
        return arrayList;
    }

    public void backTrace(String sequence, int open, int close, int number, ArrayList<String> list) {
        if (sequence.length() == number * 2) {
            list.add(sequence);
            return;
        }
        if (open < number) {
            backTrace(sequence + "(", open + 1, close, number, list);
        }
        if (close < open) {
            backTrace(sequence + ")", open, close + 1, number, list);
        }
    }
}
