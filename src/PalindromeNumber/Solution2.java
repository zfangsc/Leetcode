package PalindromeNumber;

public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long xx = x;
        long base = 1;
        while (xx >= 10) {
            base *= 10;
            xx /= 10;
        }
        xx = x;
        while (xx != 0) {
            if (xx % 10 != xx / base) {
                return false;
            }
            xx = xx % base;
            xx /= 10;
            base /= 100;
        }
        return true;
    }
}
