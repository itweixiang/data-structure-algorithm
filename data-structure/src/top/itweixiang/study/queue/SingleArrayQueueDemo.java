package top.itweixiang.study.queue;

public class SingleArrayQueueDemo {
    public static void main(String[] args) {
        SingleArrayQueue arrayQueue1 = new SingleArrayQueue(5);
        for (int i = 0; i < 3; i++) {
            arrayQueue1.add(i);
        }
        arrayQueue1.print();
        System.out.println("------");
        System.out.println(arrayQueue1.get());
        System.out.println("------");
        System.out.println(arrayQueue1.peak());
        arrayQueue1.print();
    }
}
