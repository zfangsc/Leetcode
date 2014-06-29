package LargestRectangleinHistogram;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author:  fangzhou
 * Date:    6/29/14
 * Time:    10:29 AM
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        Deque<Integer> hei = new LinkedList<Integer>();
        Deque<Integer> wid = new LinkedList<Integer>();
        hei.push(height[0]);
        wid.push(1);

        int largest = Integer.MIN_VALUE;
        for(int i = 1; i <= height.length; i++) {
            int curHeight = 0;
            if(i != height.length) {
                curHeight = height[i];
            }
            if(curHeight <= hei.peek()) {
                largest = largest < hei.peek()*wid.peek() ? hei.peek()*wid.peek() : largest;
                int prewid = wid.pop();
                hei.pop();
                while(!hei.isEmpty() && hei.peek() >= curHeight) {
                    prewid += wid.pop();
                    largest = largest < hei.peek()*prewid ? hei.peek()*prewid : largest;
                    hei.pop();
                }
                hei.push(curHeight);
                wid.push(1 + prewid);
            } else {
                hei.push(curHeight);
                wid.push(1);
            }

        }

        return largest;
    }

    public static void main(String[] args) {
        int h[] = new int[] {2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(h));
    }
}
