package FirstMissingPositive;

/**
 * Author:  fangzhou
 * Date:    4/28/14
 * Time:    10:32 PM
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A.length == 0) {
            return 1;
        }
        for(int i = 0; i < A.length; i++) {
            while(A[i]-1 >= 0 && A[i]-1 < A.length && A[i] != A[A[i]-1]) {
                int ind = A[i]-1;
                int temp = A[i];
                A[i] = A[ind];
                A[ind] = temp;
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i]-1 != i) {
                return i+1;
            }
        }
        return A.length+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[] {3,4,-1,1};
        System.out.println(s.firstMissingPositive(arr));

    }
}
