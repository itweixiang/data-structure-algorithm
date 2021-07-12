package top.itweixiang;

import java.util.*;

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
