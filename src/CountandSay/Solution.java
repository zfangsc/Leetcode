package CountandSay;

/**
 * Author: fangzhou
 * Date:   9/6/14.
 */
public class Solution {
    public String countAndSay(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        StringBuilder cur = new StringBuilder();
        StringBuilder next = new StringBuilder();
        cur.append(1);
        for (int i = 2; i <= n; i++) {
            next.setLength(0);
            for (int j = 0; j < cur.length(); j++) {
                int k = j;
                int count = 0;
                while (k < cur.length() && (k == j || cur.charAt(k) == cur.charAt(k - 1))) {
                    count++;
                    k++;
                }
                next.append(count);
                next.append(cur.charAt(j));
                j = k - 1;
            }
            cur.setLength(0);
            cur.append(next.toString());
        }
        return cur.toString();
    }
}
