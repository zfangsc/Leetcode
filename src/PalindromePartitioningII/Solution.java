package PalindromePartitioningII;

/**
 * Author: fangzhou
 * Date:   9/10/14.
 */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int[] minc = new int[s.length() + 1]; // minc[i] is the min cut for s.substring(i)
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                isPal[i][j] = false;
            }
        }
        minc[s.length()] = -1;
        for (int i = 0; i < s.length(); i++) {
            minc[i] = s.length() - i - 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    minc[i] = Math.min(minc[i], minc[j + 1] + 1);
                }
            }
        }
        return minc[0];
    }
}
