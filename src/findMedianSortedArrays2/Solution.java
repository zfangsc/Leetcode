package findMedianSortedArrays2;

/**
 * Created by fangzhou on 3/9/14.
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length == 0 && B.length == 0) {
            return 0.0;
        }
        int k = (A.length+B.length)/2-1;
        if(((A.length+B.length) & 1) == 0) {
            return ((double)findKthElement(A, B, k+1)+(double)findKthElement(A, B, k+2))/2.000;   // findKthElement is 1 based instead of 0 based
        }
        return (double)findKthElement(A, B, k+2);
    }

    public int findKthElement(int[] A, int[] B, int k) {
        Integer i = findKthElementHelper(A, B, k);
        if(i != null) {
            return i.intValue();
        }
        return findKthElementHelper(B, A, k).intValue();
    }

    public Integer findKthElementHelper(int[] A, int[] B, int k) {
        if(k > A.length+B.length || k < 0) {
            return null;
        }
        if(B.length == 0) { // one of the base condition
            return A[k-1];
        }
        int start = 0;
        int end = A.length-1;
        while(start <= end) {
            int i = start + (end - start)/2;
            int j = (k-1) - i;

            if(j-1 < 0) {   // two situations: 1. not valid;   2. smaller elements are not enough
                if(i == k-1 && j < B.length && A[i] <= B[j]) {   // situation 1
                    return A[i];
                }
                end = i-1;
                continue;
            }
            if(j-1 > B.length-1) {
                start = i+1;
                continue;
            }
            if(A[i] >= B[j-1]) {
                if(j > B.length-1 || B[j] >= A[i]) {
                    return A[i];
                }
                end = i-1;
                continue;
            }
            start = i+1;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,5,5,6};
        int[] B = new int[] {4,5,7};
        Solution s = new Solution();
        //System.out.println(s.findKthElement(A, B, 2));
        for(int i = 1; i <= A.length+B.length; i++) {
            try {
            System.out.println(s.findKthElement(A, B, i));
            } catch(Exception e) {
                System.out.println(i+"------");
            }
        }

        //System.out.println(s.findMedianSortedArrays(A, B));
    }

}
