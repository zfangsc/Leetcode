package LongestSubstringWithoutRepeatingCharacters;

/**
 * Author:  fangzhou
 * Date:    5/19/14
 * Time:    9:35 PM
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null || s.length() == 0)
            return 0;
        int[] m = new int[256];
        int len = 0, max = 0, start = 0;;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ind = (int)c;
            m[ind]++;
            len++;
            if(m[ind] == 1) {
                max = max > len ? max : len;
            }
            else {
                for(int j = start; j < i; j++) {
                    char cc = s.charAt(j);
                    int indd = (int)cc;
                    m[indd]--;
                    len--;
                    start = j+1;
                    if(m[indd] == 1) {
                        break;
                    }
                }
            }
        }
        max = max > len ? max : len;
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "bewrruion";
        System.out.println(s.lengthOfLongestSubstring(str));
    }
}
