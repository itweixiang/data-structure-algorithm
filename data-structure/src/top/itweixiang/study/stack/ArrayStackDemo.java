package top.itweixiang.study.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack= new ArrayStack(6);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.print();
        stack.pop();
        stack.pop();
        System.out.println("--------");
        stack.print();
    }
}
