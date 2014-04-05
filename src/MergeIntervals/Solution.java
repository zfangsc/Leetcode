package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

/**
 * Author:  fangzhou
 * Date:    4/5/14
 * Time:    1:48 PM
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval cur = intervals.get(0);
        for(int j = 1; j < intervals.size(); j++) {
            Interval i = intervals.get(j);
            if(intersect(cur, i)) {
                cur = merge(cur, i);
            }
            else {
                if(i.start < cur.start) {
                    result.add(i);
                }
                else {
                    result.add(cur);
                    cur = i;
                }
            }
        }
        result.add(cur);
        return result;
    }

    public boolean intersect(Interval i, Interval j) {
        return (i.start-j.start)*(i.start-j.end) <= 0 || (j.start-i.start)*(j.start-i.end) <= 0;
    }

    public Interval merge(Interval i, Interval j) {
        int start = Math.min(i.start, j.start);
        int end = Math.max(i.end, j.end);
        return new Interval(start, end);
    }

}
