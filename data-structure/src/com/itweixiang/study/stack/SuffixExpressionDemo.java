package com.itweixiang.study.stack;

public class SuffixExpressionDemo {
    public static void main(String[] args) {
        SuffixExpression suffixExpression = new SuffixExpression("1+((2+3)*4)-5");
        System.out.println(suffixExpression.result());
    }
}
