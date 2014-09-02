package LongestValidParentheses;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int l = 0, r = 0, longest = 0, lastBegin = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                l++;
            } else {
                if(l == r) {
                    int length = getLength(s, lastBegin, i);
                    longest = longest > length ? longest : length;
                    lastBegin = i+1;
                    l = 0;
                    r = 0;
                } else {
                    r++;
                }
            }
        }
        int length = getLength(s, lastBegin, s.length());
        longest = longest > length ? longest : length;
        return longest;
    }

    private int getLength(String s, int i, int j) {
        if(i >= s.length()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int m = j-1; m >= i; m--) {
            sb.append(s.charAt(m) == '(' ? ')' : '(');
        }
        int l = 0, r = 0, longest = 0, lastBegin = 0;
        for(i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(') {
                l++;
            } else {
                if(l == r) {
                    int length = i-lastBegin;
                    longest = longest > length ? longest : length;
                    lastBegin = i+1;
                    l = 0;
                    r = 0;
                } else {
                    r++;
                }
            }
        }
        longest = longest > r*2 ? longest : r*2;
        return longest;
    }
}
