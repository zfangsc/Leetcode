package MaximalRectangle;

import java.util.Stack;

/**
 * Author: fangzhou
 * Date:   9/11/14.
 */
// Histogram Algorithm comes from http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] histo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    histo[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        histo[i][j] = histo[i - 1][j] + 1;
                    }
                }
            }
        }
        int maxRec = 0;
        for (int i = 0; i < histo.length; i++) {
            int areaOf1 = largestRectangleArea(histo[i]);
            maxRec = maxRec > areaOf1 ? maxRec : areaOf1;
        }
        return maxRec;
    }

    private int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int cur = 0, maxArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        while (cur < height.length) {
            if (s.isEmpty() || height[cur] >= height[s.peek()]) {
                s.push(cur++);
            } else {
                int topH = s.pop();
                int areaOfHightTop = height[topH] * (s.isEmpty() ? cur : cur - 1 - s.peek());
                maxArea = areaOfHightTop > maxArea ? areaOfHightTop : maxArea;
            }
        }

        while (!s.isEmpty()) {
            int topH = s.pop();
            int areaOfHightTop = height[topH] * (s.isEmpty() ? cur : cur - 1 - s.peek());
            maxArea = areaOfHightTop > maxArea ? areaOfHightTop : maxArea;
        }
        return maxArea;
    }
}
