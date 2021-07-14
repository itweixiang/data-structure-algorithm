package top.itweixiang;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Stack;

/**
 * 《括号序列》
 *
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */

/*
boolean flag = true;
while(flag){
    int len = s.length();
    s=s.replace("()","");
    s=s.replace("[]","");
    s=s.replace("{}","");
    if(len == s.length()){
        flag=false;
    }
}
return s.length() == 0;
 */
public class NC52 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            String cc= String.valueOf(c);
            if (isLeft(cc) && !stack.isEmpty()) {
                stack.push(cc);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(),cc)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isLeft(String c) {
        return "(".equals(c) || "{".equals(c) || "[".equals(c);
    }

    private boolean isMatch(String s1, String s2) {
        return ("[".equals(s1) && "]".equals(s2))
                || "{".equals(s1) && "}".equals(s2)
                || "(".equals(s1) && ")".equals(s2);
    }
}
