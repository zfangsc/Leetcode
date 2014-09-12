package LargestRectangleinHistogram1;

import java.util.Stack;

/**
 * Author: fangzhou
 * Date:   9/11/14.
 */
// Algorithm comes from http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class Solution {
    public int largestRectangleArea(int[] height) {
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
