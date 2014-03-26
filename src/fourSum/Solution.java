package fourSum;

import java.util.*;
/**
 * Created by fangzhou on 3/5/14.
 */
public class Solution {

    // another problem three sum closest
    public int threeSumClosest(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length-2; i++) {
            if(i != 0 && num[i] == num[i-1]) {
                continue;
            }
            int subTarget = target-num[i];
            ArrayList<ArrayList<Integer>> subresult = twoSum(num, subTarget, i+1);
            for(ArrayList<Integer> sub : subresult) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(num[i]);
                arr.addAll(sub);
                result.add(arr);
            }
        }
        //return result;
        return 0;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int startIndex) {
        // assume that num[] is sorted
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int i = startIndex;
        int j = num.length-1;
        while(i < j) {
            if(i != startIndex && num[i] == num[i-1]) {
                i++;
                continue;
            }
            if(j != num.length-1 && num[j] == num[j+1]) {
                j--;
                continue;
            }
            if(num[i] + num[j] == target) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(num[i]);
                arr.add(num[j]);
                result.add(arr);
                i++;
                j--;
            } else if(num[i] + num[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int startIndex) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = startIndex; i < num.length-2; i++) {
            if(i != startIndex && num[i] == num[i-1]) {
                continue;
            }
            int subTarget = target-num[i];
            ArrayList<ArrayList<Integer>> subresult = twoSum(num, subTarget, i+1);
            for(ArrayList<Integer> sub : subresult) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(num[i]);
                arr.addAll(sub);
                result.add(arr);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length-2; i++) {
            if(i != 0 && num[i] == num[i-1]) {
                continue;
            }
            int subTarget = target-num[i];
            ArrayList<ArrayList<Integer>> subresult = threeSum(num, subTarget, i+1);
            for(ArrayList<Integer> sub : subresult) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(num[i]);
                arr.addAll(sub);
                result.add(arr);
            }
        }
        return result;
    }

    public static void print(ArrayList<ArrayList<Integer>> arr) {
        for(ArrayList<Integer> a : arr) {
            System.out.print("[");
            for(Integer i : a) {
                System.out.print(i+",");
            }
            System.out.println("]\n\n");
        }
    }

    public static void main(String []args){
        int[] n = new int[] {-5, -3, -2, 0, 0, 0, 1, 3, 3, 8, 8};
        print(new Solution().fourSum(n, 0));
    }
}
