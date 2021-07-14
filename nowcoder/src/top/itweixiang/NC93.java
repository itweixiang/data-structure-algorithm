package top.itweixiang;

import java.util.*;

/**
 * 《LRU缓存》
 * 
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */
public class NC93 {
    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Node> hashMap = new HashMap<>();
        LinkedList<Node> nodes = new LinkedList<>();

        for (int[] operator : operators) {
            if (operator[0] == 1) {
                if (hashMap.size() == k) {
                    Node node = nodes.removeLast();
                    hashMap.remove(node.key);
                }
                Node node = new Node(operator[1], operator[2]);
                hashMap.put(operator[1], node);
                nodes.addFirst(node);
            } else if (operator[0] == 2) {
                if (hashMap.containsKey(operator[1])) {
                    Node node = hashMap.get(operator[1]);
                    nodes.remove(node);
                    nodes.addFirst(node);
                    arrayList.add(node.value);
                } else {
                    arrayList.add(-1);
                }
            }
        }

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}

class Node {
    Integer key;
    Integer value;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(key, node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
