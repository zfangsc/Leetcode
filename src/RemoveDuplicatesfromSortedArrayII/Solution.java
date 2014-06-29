package RemoveDuplicatesfromSortedArrayII;

/**
 * Author:  fangzhou
 * Date:    5/22/14
 * Time:    9:07 PM
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        int cur = 0;
        for(int i = 0; i < A.length; i++) {
            int dupCount = 1;
            A[cur++] = A[i];
            int j = i+1;
            while(j < A.length && A[j] == A[i]) {
                dupCount++;
                if(dupCount == 2) {
                    A[cur++] = A[i];
                }
                j++;
            }
            i = j-1;
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2,2,2};
        System.out.println(s.removeDuplicates(arr));
    }
}
