package top.itweixiang;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 《合并区间》
 * <p>
 * 给出一组区间，请合并所有重叠的区间。
 * 请保证合并后的区间按区间起点升序排列。
 */

public class NC37 {
    public static void main(String[] args) {
        NC37 nc37 = new NC37();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(0, 2));
        nc37.merge(list);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = new ArrayList<>();
        if (intervals.size() == 0) return list;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            Boolean flag = true;
            for (Interval cur : list) {
                if (cur.start == tmp.start) {
                    cur.end = Math.max(cur.end, tmp.end);
                    flag = false;
                    break;
                }
                if (cur.start < tmp.start && cur.end >= tmp.start) {
                    cur.end = Math.max(cur.end, tmp.end);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(tmp);
            }
        }
        return list;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}