package ValidParentheses;

import java.util.Stack;

/**
 * Created by fangzhou on 8/18/14.
 */
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.empty()) {
                stack.push(c);
            } else {
                if(c == ')') {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if(c == ']') {
                    if(stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if(c == '}') {
                    if(stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.empty();
    }
}
