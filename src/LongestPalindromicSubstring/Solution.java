package LongestPalindromicSubstring;

/**
 * Author: fangzhou
 * Date:   9/9/14.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] lInds = new int[2];   // longest substring start and end index
        lInds[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                expand(s, i - 1, i, lInds);
            }
            expand(s, i, i, lInds);
        }
        return s.substring(lInds[0], lInds[1]);
    }

    public static void expand(String s, int i, int j, int[] lInds) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return;
            }
            if (lInds[1] - lInds[0] < j + 1 - i) {
                lInds[1] = j + 1;
                lInds[0] = i;
            }
            i--;
            j++;
        }
    }
}
