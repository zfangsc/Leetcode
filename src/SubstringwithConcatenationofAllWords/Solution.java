package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/5/14.
 */
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (L.length == 0) {
            return result;
        }
        HashMap<String, Integer> m = new HashMap<String, Integer>();
        for (String l : L) {
            if (m.containsKey(l)) {
                m.put(l, m.get(l) + 1);
            } else {
                m.put(l, 1);
            }
        }
        int wlen = L[0].length();
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        for (int i = 0; i <= S.length() - wlen * L.length; i++) {
            tmp.clear();
            for (int j = i; j <= i + (L.length - 1) * wlen; j += wlen) {
                String w = S.substring(j, j + wlen);
                if (!m.containsKey(w)) {
                    break;
                }
                if (tmp.containsKey(w)) {
                    tmp.put(w, tmp.get(w) + 1);
                } else {
                    tmp.put(w, 1);
                }
                if (tmp.get(w) > m.get(w)) {
                    break;
                }
                if (j == i + (L.length - 1) * wlen) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
