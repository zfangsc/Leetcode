package ImplementstrStr;

/**
 * Author: fangzhou
 * Date:   9/7/14.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        if (haystack.isEmpty()) {
            return needle.isEmpty() ? "" : null;
        }
        int[] table = getTable(needle);
        int i = 0, offset = 0;  // i is the current index in haystack
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(offset)) {
                offset++;
                if (offset >= needle.length()) {
                    return haystack.substring(i - offset + 1);
                }
            } else {
                if (offset != table[offset]) {
                    // i-- and later i++.
                    // This is to keep i, since we are comparing next possible position based on table
                    i--;
                }
                offset = table[offset];
            }
            i++;
        }
        return null;
    }

    // for bbbbaa : 001230
    // for issis  : 00001
    private int[] getTable(String p) {
        // assume p is not empty
        int offset = 0;
        int[] table = new int[p.length()];
        table[0] = 0;   // manually set table[0] to 0
        if (p.length() > 1) {    // manually set table[1] to 0
            table[1] = 0;
        }
        for (int i = 2; i < p.length(); i++) {
            if (p.charAt(offset) == p.charAt(i - 1)) {
                table[i] = table[i - 1] + 1;
                offset++;
            } else {
                offset = 0;
                table[i] = 0;
            }
        }
        return table;
    }

    public String strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        if (haystack.isEmpty()) {
            return needle.isEmpty() ? "" : null;
        }
        int[] table = getTable(needle);
        int start = 0, offset = 0;
        while (start + offset < haystack.length()) {
            if (haystack.charAt(start + offset) == needle.charAt(offset)) {
                offset++;
                if (offset >= needle.length()) {
                    return haystack.substring(start);
                }
            } else {
                int next = table[offset];
                start = start + offset - next;
                if (next < 0) {
                    offset = 0;
                } else {
                    offset = next;
                }
            }
        }
        return null;
    }

}
