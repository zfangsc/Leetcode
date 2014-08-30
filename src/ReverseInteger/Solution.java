package ReverseInteger;

/**
 * Author: fangzhou
 * Date:   8/30/14.
 */
public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long l = x;
        long result = 0;
        while(l > 0) {
            result *= 10;
            result += l%10;
            l /= 10;
        }
        return sign*(int)result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(-1));
    }
}
