package JumpGameII;

/**
 * Author: fangzhou
 * Date:   8/23/14.
 */
public class Solution {
    public int jump(int[] A) {
        if(A.length <= 1) {
            return 0;
        }

        int curStep = 0, reachable = 0, curStepRange = 0, curPos = 0;
        while(curPos < A.length && curPos <= reachable) {
            if(curPos + A[curPos] >= A.length-1) {
                return curStep+1;
            }
            if(curPos+A[curPos] > reachable) {
                reachable = curPos+A[curPos];
            }
            if(curPos + 1 > curStepRange) {
                curStepRange = reachable;
                curStep++;
            }
            curPos++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {2, 3, 1, 2};
        System.out.println(s.jump(A)+ " should be 2");
        A = new int[] {1, 2};
        System.out.println(s.jump(A)+ " should be 1");
        A = new int[] {1, 2, 3};
        System.out.println(s.jump(A)+ " should be 2");
        A = new int[] {1, 0, 2};
        System.out.println(s.jump(A)+ " should be 0");
        A = new int[] {3, 0, 0, 1, 1};
        System.out.println(s.jump(A)+ " should be 2");

    }
}
