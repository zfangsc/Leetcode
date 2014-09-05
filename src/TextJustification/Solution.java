package TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangzhou
 * Date:   9/4/14.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        List<String> buf = new ArrayList<String>();
        int curLen = 0;
        for(String w : words) {
            if(w.isEmpty()) {
                buf.add(w);
                continue;
            }
            if(curLen + w.length() > L) {
                result.add(process(buf, L));
                buf = new ArrayList();
                curLen = 0;
            }
            buf.add(w);
            curLen += (w.length()+1);
        }
        result.add(process(buf, L));
        releaseLast(result, L);
        return result;
    }

    public String process(List<String> buf, int L) {
        StringBuilder sb = new StringBuilder();
        if(buf.size() == 1) {   // special case for 1 word in the row
            sb.append(buf.get(0));
            while(sb.length() < L) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int[] spaces = new int[buf.size()-1];
        int len = 0;
        for(String s : buf) {
            len += s.length();
        }
        int i = 0;
        while(len < L) {
            spaces[i]++;
            i++;
            i %= spaces.length;
            len++;
        }
        for(i = 0; i < spaces.length; i++) {
            sb.append(buf.get(i));
            for(int j = 0; j < spaces[i]; j++) {
                sb.append(' ');
            }
        }
        sb.append(buf.get(buf.size()-1));
        return sb.toString();
    }

    public void releaseLast(List<String> result, int L) {
        if(result.size() > 0) {
            String last = result.get(result.size()-1);
            last = last.trim();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < last.length(); i++) {
                if(i > 0 && last.charAt(i) == ' ' && last.charAt(i-1) == ' ') {
                    continue;
                }
                sb.append(last.charAt(i));
            }
            while(sb.length() < L) {
                sb.append(' ');
            }
            result.remove(result.size()-1);
            result.add(sb.toString());
        }
    }
}
