package top.itweixiang.study.queue;

/**
 * 环形数组实现
 * <p>
 * 环形数组通过对大小取模实现。
 */
public class CircleArrayQueue {
    /**
     * front : 指向队列的第一个元素
     */
    private Integer front;
    /**
     * rear : 指向队列最后一个元素的后一个位置
     */
    private Integer rear;

    private int[] array;
    private Integer size;

    public CircleArrayQueue(int size) {
        array = new int[size];
        this.size = size;
        front = 0;
        rear = 0;
    }

    public Boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int i) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        array[rear++%size] = i;
    }

    public Integer get() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return array[front++ % size];
    }

    public Boolean isEmpty() {
        return front == rear;
    }

    public void print() {
        for (int i = front; i <= front + size(); i++) {
            System.out.println(array[i]);
        }
    }

    public Integer peak() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return array[front % size];
    }

    public Integer size() {
        //rear为当前元素的后一个位置。。
        return (rear - 1 - front) % size;
    }
}
