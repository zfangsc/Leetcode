package Triangle;

import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/12/14.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 2) {
            return triangle.isEmpty() ? 0 : triangle.get(0).get(0);
        }
        int[] path = new int[triangle.size()];
        for (int col = 0; col < triangle.get(triangle.size() - 1).size(); col++) {
            path[col] = triangle.get(triangle.size() - 1).get(col);
        }
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                path[col] = triangle.get(row).get(col) + Math.min(path[col], path[col + 1]);
            }
        }
        return path[0];
    }
}
