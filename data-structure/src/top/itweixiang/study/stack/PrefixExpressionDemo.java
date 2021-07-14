package top.itweixiang.study.stack;

public class PrefixExpressionDemo {
    public static void main(String[] args) {
        PrefixExpression expression = new PrefixExpression("1+((2222+3)*4)-5");
        System.out.println(expression.result());
    }
}
