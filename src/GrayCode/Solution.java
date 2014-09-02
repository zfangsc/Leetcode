package GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++) {
            int highestBit = 1 << i;
            int existed = result.size();
            for(int j = existed-1; j >= 0; j--) {
                result.add(highestBit+result.get(j));
            }
        }
        return result;
    }
}
