package ReverseBits;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangz on 7/13/2017.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }
        return result;
    }

    private static final Map<Integer, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < 16; i++) {
            int result = 0;
            int cur = i;
            for (int j = 0; j < 4; j++) {
                result |= ((cur & 1) << (3 - j));
                cur >>>= 1;
            }
            map.put(i, result);
        }
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result <<= 4;
            result |= map.get(n & 15);
            n >>>= 4;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
        System.out.println(new Solution().reverseBits2(1));
    }
}
