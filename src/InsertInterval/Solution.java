package InsertInterval;

import java.util.ArrayList;

/**
 * Author:  fangzhou
 * Date:    4/5/14
 * Time:    1:14 PM
 */

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



public class Solution {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval cur = newInterval;
        for(Interval i : intervals) {
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
