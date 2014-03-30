package ContainerWithMostWater;

/**
 * Created by fangzhou on 3/29/14.
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2) {
            return 0;
        }

        int max = 0;
        int start = 0, end = height.length-1;
        while(start < end) {
            int curArea = 0;
            if(height[start] < height[end]) {
                curArea = height[start] * (end - start);
                start++;
            }
            else {
                curArea = height[end] * (end - start);
                end--;
            }
            max = (max > curArea ? max : curArea);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = new int[] {3, 6, 9, 10, 3, 7};
        System.out.println(new Solution().maxArea(h));
    }
}
