package JumpGame;

/**
 * Author: fangzhou
 * Date:   8/23/14.
 */
public class Solution {
    public boolean canJump(int[] A) {
        if(A.length == 0) {
            return false;
        }

        int reachable = 0, curPos = 0;
        while(curPos < A.length && curPos <= reachable) {
            if(curPos + A[curPos] >= A.length-1) {
                return true;
            }
            if(curPos+A[curPos] > reachable) {
                reachable = curPos+A[curPos];
            }
            curPos++;
        }
        return false;
    }
}
