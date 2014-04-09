package twoSum;

import java.util.HashMap;

/**
 * Author:  fangzhou
 * Date:    4/8/14
 * Time:    9:37 PM
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = new int[] {3, 2, 4};
        int[] ind = new Solution().twoSum(a, 6);
        System.out.println(ind[0] + "," + ind[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(h.containsKey(numbers[i])) {
                if(numbers[i]*2 == target) {
                    answer[0] = h.get(numbers[i])+1;    // since index is not zero-based
                    answer[1] = i+1;
                    return answer;
                }
            } else {
                if(h.containsKey(target-numbers[i])) {
                    answer[0] = h.get(target-numbers[i])+1;
                    answer[1] = i+1;
                    return answer;
                }
                h.put(numbers[i], i);
            }
        }
        return answer;
    }


    // index sort will timeout since sorting takes a long time
    public int[] twoSum_UsingIndexSort(int[] numbers, int target) {
        int[] answer = new int[2];
        int[] index = new int[numbers.length];
        for(int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        indexSort(numbers, index, 0, numbers.length-1);

        int i = 0;
        int j = numbers.length-1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                answer[0] = index[i] > index[j] ? index[j] : index[i];
                answer[1] = index[i] > index[j] ? index[i] : index[j];
                return answer;
            }
            else if(sum > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return answer;
    }

    // quick sort
    public void indexSort(int[] num, int[] ind, int start, int end) {
        if(start < end) {
            // partition
            int pivot = num[end];
            int bound = start-1;
            for(int i = start; i < end; i++) {
                if(num[i] < pivot) {
                    bound++;
                    swap(num, ind, bound, i);
                }
            }
            swap(num, ind, bound+1, end);

            // recur
            indexSort(num, ind, start, bound);
            indexSort(num, ind, bound+2, end);
        }
    }

    public void swap(int[] a, int[] b, int i, int j) {
        if(i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }
    }

}
