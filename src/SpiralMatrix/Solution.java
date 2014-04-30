package SpiralMatrix;

import java.util.ArrayList;

/**
 * Author:  fangzhou
 * Date:    4/29/14
 * Time:    9:04 PM
 */
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return arr;
        }
        int sx = 0, sy = 0, ex = matrix.length-1, ey = matrix[0].length-1;    // start x, y  and end x, y
        while(sx <= ex && sy <= ey) {
            if(sx == ex) {
                for(int i = sy; i <= ey; i++) {
                    arr.add(matrix[sx][i]);
                }
            } else if(sy == ey) {
                for(int i = sx; i <= ex; i++) {
                    arr.add(matrix[i][sy]);
                }
            } else {
                for(int i = sy; i <= ey; i++) {
                    arr.add(matrix[sx][i]);
                }
                for(int i = sx+1; i <= ex; i++) {
                    arr.add(matrix[i][ey]);
                }
                for(int i = ey-1; i >= sy; i--) {
                    arr.add(matrix[ex][i]);
                }
                for(int i = ex-1; i >= sx+1; i--) {
                    arr.add(matrix[i][sy]);
                }
            }
            sx++;
            sy++;
            ex--;
            ey--;
        }
        return arr;
    }
}
