package SearchInsertPosition;

/**
 * Author:  fangzhou
 * Date:    4/18/14
 * Time:    5:54 PM
 */
public class Solution {

    public int searchInsert(int[] A, int target) {
        if(A.length == 0) {
            return 0;
        }

        int start = 0, end = A.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target == A[mid]) {
                return mid;
            }

            // Check boundary first
            if(A[start] >= target) {
                return start;
            }
            if(A[end] == target) {
                return end;
            }
            if(A[end] < target) {
                return end+1;
            }

            // Normal logic
            if(target > A[mid]) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return 0;
    }
}
