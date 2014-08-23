package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   8/19/14.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> l = new ArrayList<String>();
        int[] buffer = new int[4];
        restoreIpAddresses(s, buffer, 0, l);
        return l;
    }

    private void restoreIpAddresses(String s, int[] buffer, int i, List<String> resultHolder) {
        if(i == 3) {
            int integerOfS = getInteger(s);
            if(integerOfS != -1) {
                buffer[i] = integerOfS;
                resultHolder.add(""+buffer[0]+'.'+buffer[1]+'.'+buffer[2]+'.'+buffer[3]);
            }
        } else if(i < buffer.length) {
            for(int digit = 1; digit <= 3; digit++) {
                if(s.length() >= digit) {
                    int integerOfS = getInteger(s.substring(0, digit));
                    if(integerOfS != -1) {
                        buffer[i] = integerOfS;
                        restoreIpAddresses(s.substring(digit), buffer, i+1, resultHolder);
                    }
                }
            }
        }
    }

    private int getInteger(String s) {
        if(s == null || s.length() > 3 || s.isEmpty() || s.charAt(0) == '0' && s.length() > 1) {
            return -1;
        }
        int i = Integer.valueOf(s);
        if(i >= 0 && i < 256) {
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String ss = "25525511135";
        Solution s = new Solution();
        List<String> result = s.restoreIpAddresses(ss);
        System.out.println(result);
    }
}
