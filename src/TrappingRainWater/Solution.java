package TrappingRainWater;

/**
 * Author: fangzhou
 * Date:   9/9/14.
 */
public class Solution {
    public int trap(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] l = new int[A.length];
        int[] r = new int[A.length];
        l[0] = 0;
        r[A.length - 1] = 0;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < max) {
                l[i] = max;
            } else {
                max = A[i];
            }
        }
        max = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < max) {
                r[i] = max;
            } else {
                max = A[i];
            }
        }
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int min = Math.min(l[i], r[i]) - A[i];
            count += (min > 0 ? min : 0);
        }
        return count;
    }
}
