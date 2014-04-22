package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:  fangzhou
 * Date:    4/19/14
 * Time:    5:41 PM
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)
            return result;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        result.add(arr);
        Arrays.sort(num);
        arr = new ArrayList<Integer>();
        arr.add(num[0]);
        result.add(arr);
        int curStart = 1;
        for(int i = 1; i < num.length; i++) {
            int curEnd = result.size();
            if(num[i] == num[i-1]) {
                generateCurrentLevel(num[i], result, curStart, curEnd);
            }
            else {
                generateCurrentLevel(num[i], result, 0, curEnd);
            }
            curStart = curEnd;
        }

        return result;
    }

    private void generateCurrentLevel(int e, ArrayList<ArrayList<Integer>> result, int curStart, int curEnd) {
        ArrayList<Integer> arr;
        for(int c = curStart; c < curEnd; c++) {
            arr = new ArrayList<Integer>(result.get(c));
            arr.add(e);
            result.add(arr);
        }
    }

    public static void printArrayList(ArrayList<ArrayList<Integer>> arr) {
        System.out.println("[");
        for(ArrayList<Integer> a : arr) {
            print(a);
        }
        System.out.println("]");
    }

    public static void print(ArrayList<Integer> arr) {
        System.out.print("[");
        for(Integer a : arr) {
            System.out.print(a + ",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 2, 2};
        printArrayList(s.subsetsWithDup(arr));
    }
}
