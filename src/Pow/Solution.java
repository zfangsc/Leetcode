package Pow;

/**
 * Author:  fangzhou
 * Date:    3/31/14
 * Time:    10:09 PM
 */
public class Solution {
    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(eq(x, 0d)) {
            return 0;
        }
        double sign = (x < 0d ? -1d : 1d);
        if((n&0x1) == 0) {
            sign = 1d;
        }
        x = Math.abs(x);
        boolean div = n < 0;
        n = Math.abs(n);

        double rawResult = powHelper(x, n);
        if(div) {
            rawResult = 1d/rawResult;
        }
        return rawResult * sign;
    }

    public boolean eq(double x, double y) {
        return Math.abs(x-y) < 0.000000001;
    }

    // assure that x > 0 && n > 0
    public double powHelper(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }

        int halfn = n/2;
        double halfResult = powHelper(x, halfn);
        if(halfn+halfn < n) {
            return x*halfResult*halfResult;
        }
        return halfResult*halfResult;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pow(0.5, 2));
        System.out.println(s.pow(-0.5, 2));
        System.out.println(s.pow(-0.2, 3));
        System.out.println(s.pow(-2, -2));
    }
}
