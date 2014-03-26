package atoi;

/**
 * Created by fangzhou on 2/6/14.
 */
public class Solution {
    public int atoi(String str) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(str == null || str.length() == 0) {
            return 0;
        }
        int number = 0;
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        char signC = str.charAt(0);
        int sign = 1;
        if(signC == '-') {
            sign = -1;
            str = str.substring(1);
        } else if(signC == '+') {
            str = str.substring(1);
        }
        long result = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            result *= 10;
            result += (str.charAt(i)-'0');
        }
        result *= sign;
        if(result > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(result < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String n = " -0012a42 ";
        System.out.println(new Solution().atoi(n));
    }

}
