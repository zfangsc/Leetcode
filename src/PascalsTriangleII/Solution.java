package PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/12/14.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            l.add(1);
            for (int j = l.size() - 2; j > 0; j--) {
                l.set(j, l.get(j) + l.get(j - 1));
            }
        }
        return l;
    }
}
