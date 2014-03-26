package maxProfit;

/**
 * Created by fangzhou on 2/3/14.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices.length <= 1)
            return 0;

        int[] max = new int[prices.length];     // max[i] means the max profit between [0, i]
        int[] reverseMax = new int[prices.length];      // reverseMax[i] means the max profit between [i, largestIndex]

        int preSmallest = prices[0];
        max[0] = 0;
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - preSmallest > maxProfit) {
                maxProfit = prices[i] - preSmallest;
            }
            if(preSmallest > prices[i]) {
                preSmallest = prices[i];
            }
            max[i] = maxProfit;
        }

        int preLargest = prices[prices.length-1];
        reverseMax[prices.length-1] = 0;
        maxProfit = 0;
        for(int i = prices.length-2; i >=0; i--) {
            if(preLargest - prices[i] > maxProfit) {
                maxProfit = preLargest - prices[i];
            }
            if(preLargest < prices[i]) {
                preLargest = prices[i];
            }
            reverseMax[i] = maxProfit;
        }

        int largestProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(max[i] > largestProfit)
                largestProfit = max[i];
            if(reverseMax[i] > largestProfit)
                largestProfit = reverseMax[i];
            if(i+1 < prices.length) {
                if(max[i] + reverseMax[i+1] > largestProfit)
                    largestProfit = max[i] + reverseMax[i+1];
            }
        }

        return largestProfit;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};

        System.out.println(new Solution().maxProfit(A));
    }

}
