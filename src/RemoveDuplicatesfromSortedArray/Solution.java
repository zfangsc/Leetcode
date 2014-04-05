package RemoveDuplicatesfromSortedArray;

/**
 * Author:  fangzhou
 * Date:    4/5/14
 * Time:    2:16 PM
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) {
            return A.length;
        }
        int cur = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[cur]) {
                A[++cur] = A[i];
            }
        }
        return cur+1;
    }
}
