package AddBinary;

/**
 * Author: fangzhou
 * Date:   8/26/14.
 */
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) {
            return "0";
        }
        if(a == null) return b;
        if(b == null) return a;
        if(a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }

        StringBuilder aa = revert(a);
        StringBuilder bb = revert(b);
        int carry = 0;
        for(int i = 0; i < aa.length(); i++) {
            char ac = aa.charAt(i);
            int sum = carry + (int)(ac-'0');
            if(i < bb.length()) {
                sum += (int)(bb.charAt(i)-'0');
            }
            aa.setCharAt(i, (char) ('0'+sum%2));
            carry = sum/2;
        }
        if(carry != 0) {
            aa.append('1');
        }
        return aa.reverse().toString();
    }

    private StringBuilder revert(String a) {
        StringBuilder sb = new StringBuilder();
        for(int i = a.length()-1; i >= 0; i--) {
            sb.append(a.charAt(i));
        }
        return sb;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1", "1"));
    }
}
