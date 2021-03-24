package com.itweixiang.study.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 判断数字问题，正则匹配
 * 多位数拼接问题，先逐项进行拼接再进行计算，揉在一起不好处理
 * 一些规则的，之前不了解
 */
public class SuffixExpression {
    Stack<String> s1 = new Stack<>();
    Stack<String> s2 = new Stack<>();

    public Integer result() {
        for (String s : s2) {
            if (isNum(s)) {
                s1.push(s);
            } else {
                String b = s1.pop();
                String a = s1.pop();
                s1.push(String.valueOf(cal(Integer.valueOf(a), Integer.valueOf(b), s)));
            }
        }
        return Integer.valueOf(s1.pop());
    }

    public Integer cal(Integer a, Integer b, String oper) {
        if ("*".equals(oper)) {
            return a * b;
        }
        if ("/".equals(oper)) {
            return a / b;
        }
        if ("+".equals(oper)) {
            return a + b;
        }
        if ("-".equals(oper)) {
            return a - b;
        }
        return -1;
    }

    public SuffixExpression(String infix) {
        List<String> split = split(infix);

        for (String s : split) {
            if (isNum(s)) {
                s2.push(s);
            } else {
                while (true) {
                    if (s1.isEmpty() || "(".equals(s)
                            || "(".equals(s1.peek()) || priority(s) > priority(s1.peek())) {
                        s1.push(s);
                        break;
                    } else if (")".equals(s)) {
                        while (true) {
                            String pop = s1.pop();
                            if ("(".equals(pop)) {
                                break;
                            } else {
                                s2.push(pop);
                            }
                        }
                        break;
                    } else {
                        s2.push(s1.pop());
                    }
                }
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    private List<String> split(String infix) {
        List<String> list = new ArrayList<>();
        String number = "";
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isNum(ch)) {
                number += ch;
            } else {
                if (!"".equals(number)) {
                    list.add(number);
                    number = "";
                }
                list.add(String.valueOf(ch));
            }
        }
        if (!"".equals(number)) {
            list.add(number);
        }
        return list;
    }

    private Integer priority(String oper) {
        if ("*".equals(oper) || "/".equals(oper)) {
            return 1;
        } else if ("+".equals(oper) || "-".equals(oper)) {
            return 0;
        }
        return -1;
    }

    private Boolean isNum(char ch) {
        return isNum(String.valueOf(ch));
    }

    private Boolean isNum(String str) {
        return Pattern.matches("[0-9]+", str);
    }
}
