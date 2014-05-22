package LongestConsecutiveSequence;

import java.util.HashMap;

/**
 * Author:  fangzhou
 * Date:    5/21/14
 * Time:    9:35 PM
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int max = 0;
        for(int n : num) {
            if(m.containsKey(n)) {
                continue;
            }
            if(!m.containsKey(n-1) && !m.containsKey(n+1)) {
                m.put(n, n);
                max = max > 1 ? max : 1;
                continue;
            }
            m.put(n, n);
            if(m.containsKey(n-1) && m.containsKey(n+1)) {
                int begin = m.get(n-1);
                int end = m.get(n+1);
                m.put(begin, end);
                m.put(end, begin);
                max = max > end-begin+1 ? max : end-begin+1;
                continue;
            }
            if(m.containsKey(n-1)) {
                int begin = m.get(n-1);
                m.put(begin, n);
                m.put(n, begin);
                max = max > n-begin+1 ? max : n-begin+1;
            }
            if(m.containsKey(n+1)) {
                int end = m.get(n+1);
                m.put(end, n);
                m.put(n, end);
                max = max > end-n+1 ? max : end-n+1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4,3,5,6};
        System.out.println(s.longestConsecutive(arr));
    }
}
