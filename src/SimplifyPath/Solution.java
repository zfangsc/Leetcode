package SimplifyPath;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Author:  fangzhou
 * Date:    4/12/14
 * Time:    4:54 PM
 */
public class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new LinkedList<String>();
        String[] nodes = path.split("/");
        for(String n : nodes) {
            if(!n.isEmpty() && !n.equals(".")) {
                if("..".equals(n)) {
                    if(!s.isEmpty()) {
                        s.pop();
                    }
                    continue;
                }
                s.push(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        Iterator<String> iter = s.descendingIterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
            if(iter.hasNext()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "/home/.//ab/cc/./";
        System.out.println(new Solution().simplifyPath(s));
        /*String[] nodes = s.split("/");

        for(String ss : nodes) {
            System.out.println("***"+ss);
        }*/
    }
}
