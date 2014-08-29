package LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   8/28/14.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] m = new char[][]{{}, {}, {'a', 'b', 'c'},
                {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        char[] buf = new char[digits.length()];
        cal(digits, buf, 0, m, result);
        return result;
    }

    public void cal(String dig, char[] buf, int ind, char[][] m, List<String> result) {
        if (ind >= dig.length()) {
            result.add(new String(buf));
        } else {
            int d = dig.charAt(ind) - '0';
            for (char c : m[d]) {
                buf[ind] = c;
                cal(dig, buf, ind + 1, m, result);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
