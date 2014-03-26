package PalindromePartitioning;

import java.util.ArrayList;

/**
 * Created by fangzhou on 2/22/14.
 */
public class Solution {
    public int minCut(String s) {
        boolean[][] isPalin = calPalin(s);
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++) {
            buffer.add(Integer.MAX_VALUE);
        }
        for(int i = s.length()-1; i >= 0; i--) {
            Integer cur = buffer.get(i);
            for(int j =i; j < s.length(); j++) {
                if(j+1 < s.length()) {
                    int existed = buffer.get(j+1);
                    if(existed != Integer.MAX_VALUE) {
                        if(existed+1 < buffer.get(i)) {
                            if(isPalin[i][j]) {
                                buffer.set(i, existed+1);
                            }
                        }
                    }
                } else {
                    if(isPalin[i][j]) {
                        buffer.set(i, 0);
                    }
                }
            }
        }
        return buffer.get(0);
    }

    public boolean[][] calPalin(String s) {
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                isPalin[i][i+1] = true;
            }
            isPalin[i][i] = true;
        }
        isPalin[s.length()-1][s.length()-1] = true;

        for(int len = 2; len < s.length(); len++) {
            for(int start = 0; start + len < s.length(); start++) {
                int end = start+len;
                isPalin[start][end] = (s.charAt(start) == s.charAt(end) && isPalin[start+1][end-1]);
            }
        }
        return isPalin;
    }

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<ArrayList<String>>> buffer = new ArrayList<ArrayList<ArrayList<String>>>();
        for(int i = 0; i < s.length(); i++) {
            buffer.add(new ArrayList<ArrayList<String>>());
        }
        for(int i = s.length()-1; i >= 0; i--) {
            ArrayList<ArrayList<String>> cur = buffer.get(i);
            for(int j = s.length()-1; j >= i; j++) {
                String curFirstString = s.substring(i,j+1);
                if(isPalindrome(curFirstString)) {
                    ArrayList<String> curElement = new ArrayList<String>();
                    if(j+1 < s.length()) {
                        ArrayList<ArrayList<String>> existed = buffer.get(j+1);
                        for(ArrayList<String> ex : existed) {
                            curElement.add(curFirstString);
                            curElement.addAll(ex);
                            cur.add(curElement);
                            curElement = new ArrayList<String>();
                        }
                    } else {
                        curElement.add(s.substring(i,j+1));
                        cur.add(curElement);
                    }

                }
            }
        }
        return buffer.get(0);
    }

    public boolean isPalindrome(String s) {
        if(s.length() <= 1) {
            return true;
        }
        int first = 0;
        int last = s.length()-1;
        while(first < last) {
            if(s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    public static void print(ArrayList<ArrayList<String>> arrs) {
        for(ArrayList<String> arr : arrs) {
            System.out.print("[");
            for(String s : arr) {
                System.out.print("\"" + s+"\",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //print(new Solution().partition(s));
        System.out.println(new Solution().minCut(s));
    }

}
