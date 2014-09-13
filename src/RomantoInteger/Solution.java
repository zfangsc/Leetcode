package RomantoInteger;

/**
 * Author: fangzhou
 * Date:   9/13/14.
 */
// Algorithm comes from http://blog.csdn.net/wzy_1988/article/details/17057929
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        result += charToInt(s.charAt(0));
        int pre = 0, cur = 0;
        for (int i = 1; i < s.length(); i++) {
            cur = charToInt(s.charAt(i));
            pre = charToInt(s.charAt(i - 1));
            if (cur <= pre) {
                result += cur;
            } else {
                result = result - 2 * pre + cur;
            }
        }

        return result;
    }

    private static int charToInt(char c) {
        int data = 0;

        switch (c) {
            case 'I':
                data = 1;
                break;
            case 'V':
                data = 5;
                break;
            case 'X':
                data = 10;
                break;
            case 'L':
                data = 50;
                break;
            case 'C':
                data = 100;
                break;
            case 'D':
                data = 500;
                break;
            case 'M':
                data = 1000;
                break;
        }

        return data;
    }
}
