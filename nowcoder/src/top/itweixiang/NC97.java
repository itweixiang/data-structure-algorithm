package top.itweixiang;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 《字符串出现次数的TopK问题 》
 *
 * 给定一个字符串数组，再给定整数k，请返回出现次数前k名的字符串和对应的次数。
 * 返回的答案应该按字符串出现频率由高到低排序。如果不同的字符串有相同出现频率，按字典序排序。
 * 对于两个字符串，大小关系取决于两个字符串从左到右第一个不同字符的 ASCII 值的大小关系。
 * 比如"ah1x"小于"ahb"，"231"<”32“
 * 字符仅包含数字和字母
 * <p>
 * [要求]
 * 如果字符串数组长度为N，时间复杂度请达到O(Nlog⁡K)O(N \log K)O(NlogK)
 */
public class NC97 {
    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        HashMap<String, Data> map = new HashMap<>();
        TreeSet<Data> list = new TreeSet<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                Data data = map.get(str);
                list.remove(data);
                data.val++;
                list.add(data);
            } else {
                Data data = new Data(1, str);
                map.put(str, data);
                list.add(data);
            }
        }
        if (k>list.size()){
            k = list.size();
        }
        String[][] result = new String[k][];
        for (int i = 0; i < k; i++) {
            Data data = list.pollLast();
            result[i] = new String[2];
            result[i][0] = data.str;
            result[i][1] = String.valueOf(data.val);
        }
        return result;
    }

}

class Data implements Comparable<Data> {
    Integer val;
    String str;

    public Data(Integer val, String str) {
        this.val = val;
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(str, data.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public int compareTo(Data o) {
        int i = this.val.compareTo(o.val);
        if (i != 0) {
            return i;
        } else {
            return o.str.compareTo(this.str);
        }
    }
}