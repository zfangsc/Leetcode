package MultiplyStrings;

/**
 * Author: fangzhou
 * Date:   9/1/14.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();
        int[] buf = new int[num1.length()+num2.length()];
        for(int i = 0; i < sb1.length(); i++) {
            for(int j = 0; j < sb2.length(); j++) {
                buf[i+j] += (sb1.charAt(i)-'0')*(sb2.charAt(j)-'0');
            }
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < buf.length; i++) {
            buf[i] += carry;
            if(buf[i] > 9) {
                carry = buf[i]/10;
            } else {
                carry = 0;
            }
            result.append((char) ('0'+buf[i]%10));
        }
        while(result.charAt(result.length()-1) == '0' && result.length() > 1) {
            result.deleteCharAt(result.length()-1);
        }
        result.reverse();
        return result.toString();
    }
}
