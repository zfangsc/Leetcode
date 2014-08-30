package DecodeWays;

/**
 * Author: fangzhou
 * Date:   8/29/14.
 */
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int[] m = new int[s.length()];
        for(int i = s.length()-1; i >= 0 ; i--) {
            if(i+1 < s.length()) {
                m[i] = s.charAt(i) > '0' ? m[i+1] : 0;
                if(isValid(s.charAt(i), s.charAt(i+1))) {
                    if(i+2 < s.length()) {
                        m[i] += m[i+2];
                    } else {
                        m[i]++;
                    }
                }
            } else {
                m[i] = s.charAt(i) > '0' ? 1 : 0;
            }
        }
        return m[0];
    }

    private boolean isValid(char i, char j) {
        if(i == '1') {
            return true;
        }
        if(i == '2' && j < '7') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("21"));
    }
}

