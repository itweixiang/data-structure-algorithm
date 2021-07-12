package top.itweixiang;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class NC93 {
    public static void main(String[] args) {
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU(int[][] operators, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Data> datas = new ArrayList<>();

        for (int[] operator : operators) {
            if (operator[0] == 1) {
                if (datas.size() < k) {
                    extracted(arrayList, datas, operator);
                } else {
                    arrayList.remove(k - 1);
                    extracted(arrayList, datas, operator);
                }
            } else if (operator[0] == 2) {
                extracted(arrayList, datas, operator);
            }
        }

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }
        return result;

    }

    private static void extracted(ArrayList<Integer> arrayList, ArrayList<Data> datas, int[] operator) {
        Data data1 = new Data(operator[1]);
        if (datas.contains(data1)) {
            for (Data data : datas) {
                if (data.key == operator[1]) {
                    if (operator[0] == 2) {
                        arrayList.add(data.value);
                    }
                    data.score = data.score + 1;
                    break;
                }

            }
        } else {
            data1.score = 1;
            data1.value = operator[2];
            datas.add(data1);
        }
        Collections.sort(datas);
    }

    static class Data implements Comparable<Data> {
        public Data(Integer key) {
            this.key = key;
        }

        public Data(Integer key, Integer value, Integer score) {
            this.key = key;
            this.value = value;
            this.score = score;
        }

        private Integer key;
        private Integer value;
        private Integer score;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals(key, data.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public int compareTo(Data o) {
            return this.score.compareTo(o.score);
        }
    }
}
