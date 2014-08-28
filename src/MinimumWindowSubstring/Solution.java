package MinimumWindowSubstring;

/**
 * Author: fangzhou
 * Date:   8/24/14.
 */
public class Solution {
    public String minWindow(String S, String T) {
        if(S == null || S.isEmpty() || T == null || T.isEmpty()) {
            return T;
        }

        int[] needToFind = new int[256];
        for(int i = 0; i < T.length(); i++)
            needToFind[T.charAt(i)]++;

        int begin = 0, end = 0;
        int minEnd = S.length(), minBegin = -1;
        int[] hasFound = new int[256];
        int count = 0;  // number of effective chars which are in T
        while(end < S.length()) {
            if(needToFind[S.charAt(end)] == 0) {
                end++;
                continue;
            }
            hasFound[S.charAt(end)]++;
            if(hasFound[S.charAt(end)] <= needToFind[S.charAt(end)]) {
                count++;
            }
            if(count == T.length()) {
                while(begin <= end) {
                    if(needToFind[S.charAt(begin)] == 0) {
                        begin++;
                        continue;
                    }
                    if(needToFind[S.charAt(begin)] < hasFound[S.charAt(begin)]) {
                        hasFound[S.charAt(begin)]--;
                        begin++;
                    } else {
                        break;
                    }
                }

                while(minEnd-minBegin > end-begin) {
                    minEnd = end;
                    minBegin = begin;
                }
            }
            end++;
        }

        return minBegin == -1 ? "" : S.substring(minBegin, minEnd+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}
