package SortColors;

/**
 * Author: fangzhou
 * Date:   8/25/14.
 */
public class Solution {
    public void sortColors(int[] A) {
        if(A.length < 2) {
            return;
        }
        int zero = 0;
        int two = A.length-1;
        int i = 0;
        while(i <= two) {
            if(A[i] == 0) {
                swap(A, i, zero);
                zero++;
                i++;
            } else if(A[i] == 2) {
                swap(A, i, two);
                two--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
