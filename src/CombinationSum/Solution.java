package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   8/27/14.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> buf = new ArrayList<Integer>();
        cal(buf, candidates, 0, target, result);
        return result;
    }

    public void cal(ArrayList<Integer> buf, int[] cand, int cInd, int target, List<List<Integer>> result) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<Integer>(buf));
        } else {
            for(int i = cInd; i < cand.length; i++) {
                if(i > 0 && cand[i-1] == cand[i]) {
                    continue;
                }
                buf.add(cand[i]);
                cal(buf, cand, i, target-cand[i], result);
                buf.remove(buf.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] cand = new int[] {1, 2, 2, 3};
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum(cand, 3);
        System.out.println(result);
    }
}
