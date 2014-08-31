package RegularExpressionMatching;

/**
 * Author: fangzhou
 * Date:   8/31/14.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int i = 0, j = 0;
        while (!(getC(s, i) == null) || !(getC(p, j) == null)) {
            if (isEqual(getC(p, j + 1), '*')) {
                while (i < s.length()
                        && j < p.length()
                        && (i < s.length() && (getC(s, i).equals(getC(p, j)) || new Character('.').equals(getC(p, j))))) {
                    if (isMatch(s.substring(i), p.substring(j + 2))) {
                        return true;
                    }
                    i++;
                }
                return isMatch(s.substring(i), p.substring(j + 2));
            } else if (i < s.length() && (isEqual(getC(s, i), getC(p, j)) || isEqual(getC(p, j), '.'))) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    public Character getC(String x, int i) {
        if (i >= 0 && i < x.length()) {
            return new Character(x.charAt(i));
        }
        return null;
    }

    public boolean isEqual(Character c1, Character c2) {
        if(c1 == null && c2 == null) {
            return true;
        }
        if(c1 == null || c2 == null) {
            return false;
        }
        return c1.equals(c2);
    }
}
