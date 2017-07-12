package LongestHarmoniousSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangz on 7/11/2017.
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        int LHS = 0;
        for (int n : m.keySet()) {
            if (m.containsKey(n + 1)) {
                int len = m.get(n) + m.get(n + 1);
                LHS = LHS > len ? LHS : len;
            }
        }
        return LHS;
    }
}
