package Single_Number_II;

/**
 * Created by fangzhou on 3/25/14.
 */
public class Solution {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int dig = 0;
            for(int a : A) {
                dig += getBit(a, i);
                dig = dig%3;
            }
            result = setBit(result, i, dig);
        }
        return result;
    }

    // get ith bit of a
    public int getBit(int a, int i) {
        return (a >> i)&1;
    }

    public int setBit(int a, int i, int dig) {
        if(dig == 0) {
            dig = (1<<i);
            return a&(~dig);
        }
        return a | ((dig&1) << i);
    }

    public static void main(String []args){
        int[] A = new int[]{2,2,3,2};
        System.out.println(new Solution().singleNumber(A));

    }
}
