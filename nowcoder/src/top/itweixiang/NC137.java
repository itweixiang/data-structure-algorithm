package top.itweixiang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 《表达式求值》
 * <p>
 * 请写一个整数计算器，支持加减乘三种运算和括号。
 */
public class NC137 {
    public static void main(String[] args) {
        NC137 nc137 = new NC137();
        int solve = nc137.solve("(2*(3-4))*5");
        System.out.println(solve);
    }

    private Stack<String> s1 = new Stack<>();
    private Stack<String> s2 = new Stack<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        List<String> list = split(s);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (isNumber(str)) {
                s1.push(str);
            } else {
                while (true) {
                    if (s2.isEmpty() || "(".equals(str) ||
                            s2.peek().equals("(") || priority(str) > priority(s2.peek())) {
                        s2.push(str);
                        break;
                    } else if (")".equals(str)) {
                        while (true) {
                            String pop = s2.pop();
                            if ("(".equals(pop)) {
                                break;
                            } else {
                                s1.push(pop);
                            }
                        }
                        break;
                    } else {
                        s1.push(s2.pop());
                    }
                }
            }
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        for (String str : s1) {
            if (isNumber(str)) {
                s2.push(str);
            } else {
                String a = s2.pop();
                String b = s2.pop();
                s2.push(cal(a, b, str));
            }
        }
        return Integer.valueOf(s2.peek());
    }

    private String cal(String a, String b, String oper) {
        if ("*".equals(oper)) {
            return String.valueOf(Integer.valueOf(a) * Integer.valueOf(b));
        }
        if ("/".equals(oper)) {
            return String.valueOf(Integer.valueOf(a) / Integer.valueOf(b));
        }
        if ("-".equals(oper)) {
            return String.valueOf(Integer.valueOf(b) - Integer.valueOf(a));
        }
        if ("+".equals(oper)) {
            return String.valueOf(Integer.valueOf(a) + Integer.valueOf(b));
        }
        return null;
    }

    public Integer priority(String s) {
        if ("*".equals(s) || "/".equals(s)) {
            return 2;
        } else {
            return 1;
        }
    }

    public List<String> split(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String number = "";
        for (int i = 0; i < chars.length; i++) {
            if (isNumber(chars[i])) {
                number += chars[i];
            } else {
                if (!"".equals(number)) {
                    list.add(number);
                    number = "";
                }
                list.add(String.valueOf(chars[i]));
            }
        }
        if (!"".equals(number)) {
            list.add(number);
        }
        return list;
    }

    public Boolean isNumber(char ch) {
        return isNumber(String.valueOf(ch));
    }

    public Boolean isNumber(String s) {
        return s.matches("[0-9]+");
    }
}
