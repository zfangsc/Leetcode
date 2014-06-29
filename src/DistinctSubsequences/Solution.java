package DistinctSubsequences;

/**
 * Author:  fangzhou
 * Date:    5/21/14
 * Time:    10:06 PM
 */

//https://oj.leetcode.com/problems/distinct-subsequences/

public class Solution {
    public int numDistinct(String S, String T) {
        // m[i][j] : the number of dinstince subsequences of S[i:] and T[j:] given the subsequences will start from s[i] and t[j] (s[i] == t[j])
        int[][] m = new int[S.length()+1][T.length()+1];
        for(int i = 0; i < S.length(); i++) {
            m[i][T.length()] = 1;
        }
        int count = 0;
        for(int i = S.length()-1; i >= 0; i--) {
            for(int j = T.length()-1; j >= 0; j--) {
                int len = 0;
                if(S.charAt(i) == T.charAt(j)) {
                    for(int k = i+1; k < S.length(); k++) {
                        len += m[k][j+1];
                    }
                }
                if(j == 0) {
                    count += len;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String S = "abbbt", T = "abt";
        System.out.println(s.numDistinct(S, T));
    }
}
