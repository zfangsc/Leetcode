package NQueens;

import java.util.ArrayList;

/**
 * Author:  fangzhou
 * Date:    4/21/14
 * Time:    8:17 PM
 */
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        int[] buf = new int[n];
        ArrayList<String[]> result = new ArrayList<String[]>();
        solve(buf, result, 0);
        return result;
    }

    public void solve(int[] buf, ArrayList<String[]> result, int curInd) {
        if(curInd == buf.length) {
            result.add(getSolution(buf));
        }
        else {
            for(int i = 0; i < buf.length; i++) {
                boolean fail = false;
                for(int pre = 0; pre < curInd; pre++) {
                    if(buf[pre] == i || Math.abs(buf[pre]-i) == Math.abs(pre-curInd)) {
                        fail = true;
                        break;
                    }
                }
                if(fail == false) {
                    buf[curInd] = i;
                    solve(buf, result, curInd+1);
                }
            }
        }
    }

    public String[] getSolution(int[] buf) {
        String[] s = new String[buf.length];
        for(int row = 0; row < buf.length; row++) {
            int place = buf[row];
            StringBuffer sb = new StringBuffer();
            for(int col = 0; col < buf.length; col++) {
                if(col == place) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            s[row] = sb.toString();
        }
        return s;
    }

    public void print(String[] s) {
        System.out.println("[");
        for(String ss : s) {
            System.out.println(ss);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String[]> ans = s.solveNQueens(5);
        for(String[] ss : ans) {
            System.out.println("*****************");
            s.print(ss);
            System.out.println("*****************");
        }
    }
}
