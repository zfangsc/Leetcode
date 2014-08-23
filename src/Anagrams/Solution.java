package Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   8/22/14.
 */
public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String, String> m = new HashMap<String, String>();
        List<String> result = new ArrayList<String>();
        for(String s : strs) {
            String key = sort(s);
            if(m.containsKey(key)) {
                result.add(s);
                if(m.get(key) != null) {
                    result.add(m.get(key));
                    m.remove(key);
                    m.put(key, null);
                }
            } else {
                m.put(key, s);
            }
        }
        return result;
    }

    public String sort(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
