package KMP;

/**
 * Created by fangzhou on 2/4/14.
 */
public class KMP {

    public static String strStr(String haystack, String needle) {
        // wrapper
        int firstOcc = strstr(haystack, needle);
        if(firstOcc < 0)
            return null;

        return haystack.substring(firstOcc);
    }

    // find P(pattern) in S string
    public static int strstr(String S, String P) {
        if(S == null || P == null) {
            return -1;
        }
        if(P.length() == 0) {
            return 0;
        }
        if(S.length() == 0) {
            return -1;
        }

        int[] table = getTable(P);
        int start = 0;
        int offset = 0;
        while(start+offset < S.length()) {
            char c = S.charAt(start+offset);
            char p = P.charAt(offset);
            if(c == p) {
                offset++;
                if(offset >= P.length()) {
                    return start;
                }
            }
            else {
                int next = table[offset];
                start = start + offset - next;
                if(next > 0) {
                    offset = next;
                }
                else {
                    offset = 0;
                }
            }

        }


        return -1;
    }

    public static int[] getTable(String p) {
        int[] array = new int[p.length()];
        array[0] = -1;
        if(p.length() > 2) {
            array[1] = 0;
        }

        int cur = 0;
        for(int i = 2; i < p.length(); i++) {
            char c = p.charAt(i-1);
            if(c == p.charAt(cur)) {
                array[i] = array[i-1] + 1;
                cur++;
            }
            else {
                array[i] = 0;
                cur = 0;
            }
        }

        return array;
    }

    public static void printArray(int[] arr) {
        if(arr != null) {
            for(int a:arr) {
                System.out.print(a+",");

            }
        }
    }

    public static void main(String[] args) {
        String s = "abaacabaacbe";
        String p = "aacb";
        printArray(KMP.getTable(p));
        System.out.println(KMP.strStr(s, p));
    }
}
