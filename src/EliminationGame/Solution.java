package EliminationGame;

/**
 * Created by fangz on 7/8/2017.
 */
public class Solution {
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private int leftToRight(int n) {
        if (n <= 2) {
            return n;
        }
        return 2 * rightToLeft(n/2);
    }

    private int rightToLeft(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n % 2 == 1) {
            return 2 * leftToRight(n/2);
        }
        return 2 * leftToRight(n/2) - 1;
    }
}
