package Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:  fangzhou
 * Date:    3/31/14
 * Time:    10:37 PM
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(num);
        do {
            ArrayList<Integer> perm = new ArrayList<Integer>();
            for(int i : num) {
                perm.add(i);
            }
            answer.add(perm);
        } while(tryNext(num));
        return answer;
    }

    public boolean tryNext(int[] num) {
        for(int i = num.length-1; i >= 0; i--) {
            if(i-1 >= 0) {
                if(num[i] > num[i-1]) {
                    int j = i+1;
                    while(j < num.length && num[j] > num[i-1]) {
                        j++;
                    }
                    swap(num, i-1, j-1);
                    Arrays.sort(num, i, num.length);
                    return true;
                }
            }
        }
        return false;
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = new int[] {3, 3, 6, 5, 1};
        ArrayList<ArrayList<Integer>> result = s.permuteUnique(num);
        for(ArrayList<Integer> arr : result) {
            for(Integer i: arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
