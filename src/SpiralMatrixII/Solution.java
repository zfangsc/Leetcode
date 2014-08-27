package SpiralMatrixII;

/**
 * Author: fangzhou
 * Date:   8/26/14.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int sx = 0, sy = 0, ex = n-1, ey = n-1;
        int[][] m = new int[n][n];
        int count = 1;
        while(sx <= ex) {
            if(sx == ex) {
                m[sx][sy] = count;
                break;
            }
            for(int i = sy; i < ey; i++) {
                m[sx][i] = count++;
            }
            for(int i = sx; i < ex; i++) {
                m[i][ey] = count++;
            }
            for(int i = ey; i > sy; i--) {
                m[ex][i] = count++;
            }
            for(int i = ex; i > sx; i--) {
                m[i][sy] = count++;
            }
            sx++; sy++;
            ex--; ey--;
        }

        return m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateMatrix(3));
    }
}
