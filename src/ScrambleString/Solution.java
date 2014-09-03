package ScrambleString;

/**
 * Author: fangzhou
 * Date:   9/2/14.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] m = new boolean[s1.length()][s1.length()][s1.length()];
        for(int len = 0; len < s1.length(); len++) {
            for(int i = 0; i < s1.length()-len; i++) {
                for(int j = 0; j < s2.length()-len; j++) {
                    if(len == 0) {
                        m[i][j][0] = s1.charAt(i) == s2.charAt(j) ? true : false;
                        continue;
                    }
                    for(int split = 0; split < len; split++) {
                        m[i][j][len] |= m[i][j][split] && m[i+split+1][j+split+1][len-split-1];
                        m[i][j][len] |= m[i][len+j-split][split] && m[i+split+1][j][len-split-1];
                        if(m[i][j][len]) {
                            break;
                        }
                    }
                }
            }
        }
        return m[0][0][s1.length()-1];
    }
}
