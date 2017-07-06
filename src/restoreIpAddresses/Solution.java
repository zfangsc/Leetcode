package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by fangzhou on 2/25/14.
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<String>();
        }

        return restoreIpHelper(s, 4);
    }

    public ArrayList<String> restoreIpHelper(String s, int sec) {
        if (sec < 1 || sec > 4 || s == null || s.length() == 0) {
            return null;
        }
        ArrayList<String> result = new ArrayList<String>();
        if (sec == 1) {
            if (s.length() > 3) {
                return null;
            }
            if (s.charAt(0) == '0' && s.length() > 1) {
                return null;    // skip 00, 01 ...
            }
            int number = Integer.parseInt(s);
            if (number < 256) {
                result.add(s);
                return result;
            } else {
                return null;
            }
        }
        for (int dig = 1; dig <= 3; dig++) {
            if (s.length() > dig) {
                String current_number = s.substring(0, dig);
                if (current_number.charAt(0) == '0' && current_number.length() > 1) {
                    continue;   // skip 00, 01 ...
                }
                if (Integer.parseInt(current_number) > 255) {
                    continue;
                }
                String rest_number = s.substring(dig);
                ArrayList<String> rest = restoreIpHelper(rest_number, sec - 1);
                if (rest != null) {
                    for (int i = 0; i < rest.size(); i++) {
                        String restAdd = rest.get(i);
                        result.add(current_number + "." + restAdd);
                    }
                }
            }
        }
        return result;
    }

    public static void printArray(ArrayList<String> arr) {
        if (arr != null) {
            ListIterator<String> iterator = arr.listIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());

            }
        }
    }

    public static void main(String[] args) {
        String ip = "172162541";
        printArray(new Solution().restoreIpAddresses(ip));
    }
}
