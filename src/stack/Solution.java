package stack;

import java.util.Stack;

/**
 * leetCode第二十题 有效的括号
 * @author roy f
 */
public class Solution {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final Character topChar = stack.pop();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
