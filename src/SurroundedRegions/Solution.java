package SurroundedRegions;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by fangzhou on 2/22/14.
 */
public class Solution {
    public static void main(String[] args) {
        //String[] strings = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        //["XXXXOOXXO","OOOOXXOOX","XOXOOXXOX","OOXXXOOOO","XOOXXXXXO","OOXOXOXOX","OOOXXOXOX","OOOXOOOXO","OXOOOXOXO"]
        char[][] strings = new char[][]{"XXXXOOXXO".toCharArray(),"OOOOXXOOX".toCharArray(),
                "XOXOOXXOX".toCharArray(), "OOXXXOOOO".toCharArray(), "XOOXXXXXO".toCharArray(),
                "OOXOXOXOX".toCharArray(), "OOOXXOXOX".toCharArray(), "OOOXOOOXO".toCharArray(),
                "OXOOOXOXO".toCharArray()};

        printArray(strings, "***Original***");
        new Solution().solve(strings);
        printArray(strings, "***Final***");
    }

    public static void printArray(char[][] b, String s) {
        System.out.println(s);
        for(char[] chars : b) {
            for(char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public void solve(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(board.length <= 1 || board[0].length <= 1) {
            return;
        }
        freezeBoundary(board, 'O', 'F');
        flapZero(board);
        unfreezeBoundary(board, 'O', 'F');
    }

    public void toggleBoundary(char[][] b, char oo, char ff) {
        for(int j = 0; j < b[0].length; j++) {
            if(b[0][j] == oo) {
                b[0][j] = ff;
            }
        }
        for(int j = 0; j < b[b.length-1].length; j++) {
            if(b[b.length-1][j] == oo) {
                b[b.length-1][j] = ff;
            }
        }
        for(int i = 0; i < b.length; i++) {
            if(b[i][0] == oo) {
                b[i][0] = ff;
            }
        }
        for(int i = 0; i < b.length; i++) {
            if(b[i][b[0].length-1] == oo) {
                b[i][b[0].length-1] = ff;
            }
        }
        printArray(b, "***step 1***");


        // top to bottom
        for(int i = 1; i < b.length-1; i++) {
            boolean change = false;
            for(int j = 1; j < b[0].length-1; j++) {
                if(b[i-1][j] == ff && b[i][j] == oo) {
                    change = true;
                    b[i][j] = ff;
                    int left = j-1;
                    while(left >= 1 && b[i][left] == oo) {
                        b[i][left] = ff;
                        left--;
                    }
                    int right = j+1;
                    while(right < b[i].length-1 && b[i][right] == oo) {
                        b[i][right] = ff;
                        right++;
                    }
                }
            }
        }
        printArray(b, "***step 2 top to bottom***");
        // bottom to top

        for(int i = b.length-2; i > 0; i--) {
            boolean change = false;
            for(int j = 1; j < b[0].length-1; j++) {
                if(b[i+1][j] == ff && b[i][j] == oo) {
                    change = true;
                    b[i][j] = ff;
                    int left = j-1;
                    while(left >= 1 && b[i][left] == oo) {
                        b[i][left] = ff;
                        left--;
                    }
                    int right = j+1;
                    while(right < b[i].length-1 && b[i][right] == oo) {
                        b[i][right] = ff;
                        right++;
                    }
                }
            }
        }
        printArray(b, "***step 3 bottom to top***");
        // left to right

        for(int j = 1; j < b[0].length-1; j++) {
            boolean change = false;
            for(int i = 1; i < b.length-1; i++) {
                if(b[i][j-1] == ff) {
                    if(b[i][j] == oo) {
                        change = true;
                        b[i][j] = ff;
                    }
                    int up = i-1;
                    while(up >= 1 && b[up][j] == oo) {
                        b[up][j] = ff;
                        up--;
                    }
                    int down = i+1;
                    while(down < b[i].length-1 && b[down][j] == oo) {
                        b[down][j] = ff;
                        down++;
                    }
                }
            }
        }
        printArray(b, "***step 4 left to right***");
        // right to left

        for(int j = b[0].length-2; j > 0; j--) {
            boolean change = false;
            for(int i = 1; i < b.length-1; i++) {
                if(b[i][j+1] == ff && b[i][j] == oo) {
                    change = true;
                    b[i][j] = ff;
                    int up = i-1;
                    while(up >= 1 && b[up][j] == oo) {
                        b[up][j] = ff;
                        up--;
                    }
                    int down = i+1;
                    while(down < b[i].length-1 && b[down][j] == oo) {
                        b[down][j] = ff;
                        down++;
                    }
                }
            }
        }
        printArray(b, "***step 5 right to left***");
    }

    public void freezeBoundary(char[][] b, char oo, char ff) {
        toggleBoundary(b, oo, ff);
    }

    public void unfreezeBoundary(char[][] b, char oo, char ff) {
        //toggleBoundary(b, ff, oo);
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                if(b[i][j] == 'F') {
                    b[i][j] = 'O';
                }
            }
        }
    }

    public void flapZero(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
