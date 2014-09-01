package ValidPalindrome;

/**
 * Author: fangzhou
 * Date:   8/31/14.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
            } else if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
            } else {
                if(s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
