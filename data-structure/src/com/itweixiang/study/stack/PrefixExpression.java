package com.itweixiang.study.stack;

import java.util.*;
import java.util.regex.Pattern;


public class PrefixExpression {

    Stack<String> s1 = new Stack<>();
    Stack<String> s2 = new Stack<>();

    public Integer result() {
        while (!s2.isEmpty()) {
            String pop = s2.pop();
            if (isNum(pop)) {
                s1.push(pop);
            } else {
                String a = s1.pop();
                String b = s1.pop();
                s1.push(String.valueOf(cal(Integer.valueOf(a), Integer.valueOf(b), pop)));
            }
        }
        return Integer.valueOf(s1.pop());
    }

    public PrefixExpression(String infix) {
        List<String> split = split(infix);
        for (String s : split) {
            if (isNum(s)) {
                s2.push(s);
            } else {
                while (true) {
                    if (s1.isEmpty() || ")".equals(s) || ")".equals(s1.peek())
                            || priority(s) >= priority(s1.peek())) {
                        s1.push(s);
                        break;
                    } else if ("(".equals(s)) {
                        while (true) {
                            String pop = s1.pop();
                            if (")".equals(pop)) {
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
        Collections.reverse(s2);
//        for (String s : s2) {
//            System.out.print(s + " ");
//        }
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
        //反转
        Collections.reverse(list);
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
