package com.itweixiang.study.stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class SuffixExpression {
    private Stack<String> stack;

    public SuffixExpression(String infix) {
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isNum(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String peek = stack.peek();
                if (isNum(peek)) {
                    stack.push(String.valueOf(ch));
                } else if (priority()) {

                } else if (priority(peek.charAt(0)) > priority(ch)) {
                    String pop = stack.pop();
                }
            }
        }
    }

    public Integer result() {
        return 0;
    }

    public Boolean isNum(char ch) {
        return isNum(String.valueOf(ch));
    }

    public Boolean isNum(String ch) {
        return Pattern.matches("[0-9]", ch);
    }

    public Integer priority(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '(' || ch == ')') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 0;
        }
    }

}
