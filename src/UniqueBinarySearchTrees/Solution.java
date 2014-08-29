package UniqueBinarySearchTrees;

/**
 * Author: fangzhou
 * Date:   8/28/14.
 */
public class Solution {
    public int numTrees(int n) {
        int[] nt = new int[n+1];  // nT[i] => the number of unique BST for i nodes
        if(n <= 0) {
            return 0;
        }
        nt[0] = 1;
        nt[1] = 1;
        if(n >= 2)
            nt[2] = 2;
        for(int i = 3; i < n+1; i++) {
            for(int j = 0; j < i; j++) {
                nt[i] += nt[j] * nt[i-j-1];
            }
        }
        return nt[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
