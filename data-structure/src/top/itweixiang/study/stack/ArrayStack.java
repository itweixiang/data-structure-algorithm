package top.itweixiang.study.stack;

public class ArrayStack {
    private Integer size;
    private int[] array;

    /**
     * 栈定，初始化大小为-1
     */
    private int top = -1;

    public ArrayStack(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public void push(int i) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        } else {
            array[++top] = i;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            return array[top--];
        }
    }

    public int peek() {
        return array[top];
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(array[i]);
        }
    }

    public Boolean isFull() {
        return top == size - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }
}
