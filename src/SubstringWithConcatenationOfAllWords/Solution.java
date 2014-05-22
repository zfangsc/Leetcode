package SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:  fangzhou
 * Date:    4/22/14
 * Time:    8:09 PM
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "barfoothefoobarman";
        String[] dict = new String[] {"foob","bar"};
        ArrayList<Integer> ans = s.findSubstring(ss, dict);
        for(Integer i : ans) {
            System.out.println("*****************");
            System.out.println(i);
            System.out.println("*****************");
        }
    }

/*
    This problem is easier than it appears. We can solve it in O(word length * string length) time.
    I just give a hint here, because it shows it is from topcoder.
    Since all the words have the same length, we can conduct the search for length-of-word passes, with each pass offsetting 1 more character.
    e.g. Given:
    lingmindraboofooowingdingbarrwingmonkeypoundcake
    we do it in 4 passes, spaces shows how we treat the strings.
    1: ling mind rabo ofoo ..
    2: ingm indr aboo fooo
    3: ngmi ndra ..
    4: gmin drab ...
    You will find it is easy to handle 1 pass (O(string length) time), The remaining is trivial too.
    */

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indices = new ArrayList<Integer>();


        /*if (L.length == 0) return indices;

        int total = L.length, wordLen = L[0].length();

        // store the words and frequencies in a hash table
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String s : L) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s)+1);
            } else {
                words.put(s, 1);
            }
        }

        // find concatenations
        for (int i=0; i <= S.length() - total*wordLen; ++i) {
            // check if it is a concatenation
            HashMap<String, Integer> target = new HashMap<String, Integer>(words);
            for (int j = i; j <= S.length() - wordLen && !target.isEmpty(); j+=wordLen) {
                String sub = S.substring(j, j+wordLen);
                if (!target.containsKey(sub)) break;
                if (target.get(sub) > 1) {  // reduce the frequency
                    target.put(sub, target.get(sub)-1);
                } else {  // remove the word if only one left
                    target.remove(sub);
                }
            }
            if (target.isEmpty()) {
                indices.add(i);
            }
        }*/

        return indices;
    }
}
