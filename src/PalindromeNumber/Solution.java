package PalindromeNumber;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int factor = 1;
        while(x/factor >= 10) {
            factor *= 10;
        }
        while(x != 0) {
            if(x/factor != x%10) {
                return false;
            }
            x = x%factor;
            x /= 10;
            factor /= 100;
        }
        return true;
    }
}
