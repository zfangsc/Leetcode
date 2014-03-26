package fullJustify;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by fangzhou on 2/8/14.
 */

class justifier {
    ArrayList<Row> text = new ArrayList<Row>();
    final int L;
    public justifier(int len) {
        L = len;
    }

    public void add(String s) {
        if(text.size() == 0) {
            text.add(new Row());
        }
        Row last = text.get(text.size()-1);
        if(!last.tryAdd(s)) {
            Row r = new Row();
            r.tryAdd(s);
            text.add(r);
        }
    }

    public ArrayList<String> getText() {
        ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < text.size(); i++) {
            if(i != text.size()-1) {
                result.add(text.get(i).getRow());
            }
            else {
                result.add(text.get(i).getLastRow());
            }
        }
        return result;
    }

    class Row {
        ArrayList<String> words = new ArrayList<String>();
        int curLen = 0;
        int curLenWithoutSpace = 0;
        public boolean tryAdd(String s) {
            if(curLen == 0) {
                if(s.length() <= L) {
                    words.add(s);
                    curLen = s.length();
                    curLenWithoutSpace = curLen;
                    return true;
                }
                else {
                    return false;   // should throw exception
                }
            }
            else {
                if(curLen+1+s.length() <= L) {
                    words.add(s);
                    curLen += (1+s.length());
                    curLenWithoutSpace += s.length();
                    return true;
                }
            }
            return false;
        }

        public String getRow() {
            int[] spaces = new int[words.size()-1];
            if(words.size() == 1) {
                spaces = new int[1];
            }
            int index = 0;
            while(curLenWithoutSpace < L) {
                curLenWithoutSpace++;
                spaces[index]++;
                index++;
                index %= spaces.length;
            }

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if(i < spaces.length) {
                    for(int j = 0; j < spaces[i]; j++)
                        sb.append(' ');
                }
            }

            return sb.toString();
        }

        public String getLastRow() {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if(i != words.size()-1)
                    sb.append(' ');
            }
            while(sb.length() < L) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

}


public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        if(words.length == 0) {
            return new ArrayList<String>();
        }
        justifier j = new justifier(L);
        for(String s : words) {
            if(s.length() > L)
                return null;
            j.add(s);
        }

        return j.getText();
    }

    public static void printArray(ArrayList<String> arr) {
        if(arr != null) {
            ListIterator<String> iterator = arr.listIterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());

            }
        }
    }

    public static void main(String[] args) {
        //String[] strings = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        String[] strings = new String[]{"a"};

        printArray(new Solution().fullJustify(strings, 3));
    }
}
