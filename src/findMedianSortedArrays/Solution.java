package findMedianSortedArrays;

/**
 * Created by fangzhou on 2/1/14.
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length + B.length;
        if(n == 0)
            return -1;
        if(n%2 == 0) {
            int n1 = n/2;
            int n2 = n1 + 1;
            int first = findNthSortedArrays(A, B, n1, 0, A.length-1, 0, B.length-1);
            int second = findNthSortedArrays(A, B, n2, 0, A.length-1, 0, B.length-1);
            return ((double)first + (double)second)/2;
        }
        n = (n+1)/2;
        return (double)(findNthSortedArrays(A, B, n, 0, A.length-1, 0, B.length-1));
    }


    public int findNthSortedArrays(int A[], int B[], int n, int as, int ae, int bs, int be) {
        // case 1: One array is empty
        if(A.length == 0) {
            return findNthSortedArray(B, n, bs, be);
        }
        if(B.length == 0) {
            return findNthSortedArray(A, n, as, ae);
        }

        // case 2: not found target in A, switch to B
        if(as > ae)
            return findNthSortedArrays(B, A, n, 0, B.length-1, 0, A.length-1);

        // case 3: normal case
        // when j-1 <= i <= j, i is the nth node, where n = i+1 + (j-1) + 1
        // i is inversely proportional to j
        int i = as + (ae-as)/2;
        int j = n - (i+1);

        int smaller = i;

        if(j-1 >= 0 && j-1 < B.length) {
            if(A[i] >= B[j-1]) {
                smaller += j;
                if(j < B.length && j >= 0)
                    if(A[i] > B[j]) {
                        smaller = Integer.MAX_VALUE;
                    }
            }
            else
                smaller = Integer.MIN_VALUE;
        } else {

            if(j >= 0 && j < B.length && A[i] > B[j])
                smaller = Integer.MAX_VALUE;
        }

        if(smaller+1 == n)
            return A[i];
        if(smaller > n-1)
            return findNthSortedArrays(A, B, n, as, i-1, bs, be);
        return findNthSortedArrays(A, B, n, i+1, ae, bs, be);
    }

    public int findNthSortedArray(int X[], int n, int start, int end) {
        if(end >= start+n-1)
            return X[start+n-1];
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1};
        int[] B = new int[]{2,3,4,5,6};

        System.out.println(new Solution().findMedianSortedArrays(A, B));
    }
}
