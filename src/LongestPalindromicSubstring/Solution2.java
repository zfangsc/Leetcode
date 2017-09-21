package LongestPalindromicSubstring;

public class Solution2 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = expand(s, i, i, result);
            if (i + 1 < s.length()) {
                result = expand(s, i, i + 1, result);
            }
        }
        return result;
    }

    private String expand(String s, int center1, int center2, String currentLongest) {
        int start = center1, end = center1;
        while (center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
            center1--;
            center2++;
        }
        center1++;
        center2--;
        return currentLongest.length() >= center2 - center1 + 1 ? currentLongest : s.substring(center1, center2 + 1);
    }
}
