package MaximumSubarray;

/**
 * Author:  fangzhou
 * Date:    4/5/14
 * Time:    2:07 PM
 */
public class Solution {
    /*public int maxSubArray(int[] A) {
        // assume that the sum of subarray cannot be negative
        int sumendinghere = 0;
        int sumsofar = 0;
        for(int i : A) {
            sumendinghere = Math.max(0, sumendinghere+i);
            sumsofar = Math.max(sumsofar, sumendinghere);
        }
        return sumsofar;
    }*/

    public int maxSubArray(int[] A) {
        // assume that the sum of subarray can be negative
        // assume A.length > 0
        int sumendinghere = A[0];
        int sumsofar = A[0];
        for(int j = 1; j < A.length; j++) {
            int i = A[j];
            sumendinghere = Math.max(i, sumendinghere+i);
            sumsofar = Math.max(sumsofar, sumendinghere);
        }
        return sumsofar;
    }
}
