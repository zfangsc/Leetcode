package ThreeSumClosest;

import java.util.Arrays;

/**
 * Author: fangzhou
 * Date:   9/4/14.
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3) {
            return -1;
        }
        Arrays.sort(num);
        int[] closest = new int[1];
        closest[0] = Integer.MAX_VALUE-target;
        for(int i = 0; i < num.length-2; i++) {
            findClosest(num, i+1, num.length-1, num[i], target, closest);
        }
        return closest[0];
    }

    public void findClosest(int[] num, int start, int end, int firstValue, int target, int[] closest) {
        while(start < end) {
            int sum = firstValue + num[start] + num[end];
            if(Math.abs(closest[0]-target) > Math.abs(sum-target)) {
                closest[0] = sum;
            }
            if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
    }
}
