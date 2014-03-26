package isScramble;

/**
 * Created by fangzhou on 2/8/14.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null) {
            return true;
        }
        if(s1.equals(s2)) {
            return true;
        }
        if(s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] m = new boolean[s1.length()][s2.length()][s1.length()];   // m[i][j][l] => start i in s1, j in s2, length l+1

        for(int l = 0; l < s1.length(); l++) {
            for(int i = 0; i < s1.length()-l; i++) {
                for(int j = 0; j < s2.length()-l; j++) {
                    if(l == 0) {
                        m[i][j][l] = (s1.charAt(i) == s2.charAt(j));
                        continue;
                    }
                    for(int splitLen = 0; splitLen < l; splitLen++) {
                        m[i][j][l] |= m[i][j][splitLen]&&m[i+splitLen+1][j+splitLen+1][l-splitLen-1];
                        m[i][j][l] |= m[i][j+l-splitLen][splitLen]&&m[i+splitLen+1][j][l-splitLen-1];
                        if(m[i][j][l] == true) {
                            break;
                        }
                    }
                }
            }
        }
        return m[0][0][s1.length()-1];
    }


    public static void main(String[] args) {
        String s = "great";
        String p = "rgtae";
        System.out.println(new Solution().isScramble(s, p));
    }
}