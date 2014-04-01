package WordBreakII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:  fangzhou
 * Date:    3/29/14
 * Time:    10:04 PM
 */
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<Integer>> nextIndex = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < s.length(); i++) {
            nextIndex.add(new ArrayList<Integer>());
        }
        ArrayList<Integer> lastGuard = new ArrayList<Integer>();
        lastGuard.add(-1);
        nextIndex.add(lastGuard);

        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = i+1; j < s.length()+1; j++) {
                String word = s.substring(i, j);    // from i to j-1
                if(dict.contains(word)) {
                    if(!nextIndex.get(j).isEmpty()) {
                        nextIndex.get(i).add(j);
                    }
                }
            }
        }

        return getSentences(s, nextIndex, 0);
    }

    public ArrayList<String> getSentences(String s, ArrayList<ArrayList<Integer>> nextIndex, int cur) {
        ArrayList<String> answer = new ArrayList<String>();
        if(cur > nextIndex.size()-1) {
            return answer;
        }
        ArrayList<Integer> nexts = nextIndex.get(cur);
        for(Integer next : nexts) {
            if(next == -1) {
                answer.add(s.substring(cur));
                return answer;
            }
            String curString = s.substring(cur, next);
            ArrayList<String> remainStrings = getSentences(s, nextIndex, next);
            for(String remain : remainStrings) {
                if(!remain.isEmpty()) {
                    answer.add(curString+" "+remain);
                } else {
                    answer.add(curString);
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "catsanddog";
        String[] dictArray = {"cat", "cats", "and", "sand", "dog"};
        Set<String> dict = new HashSet<String>();
        Collections.addAll(dict, dictArray);
        ArrayList<String> result = s.wordBreak(ss, dict);
        for(String sss : result) {
            System.out.println(sss);
        }
    }

}
