import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save current string
                stack.push(curr.toString());
                curr.setLength(0);

            } else if (ch == ')') {
                // Reverse current substring
                curr.reverse();

                // Add it to the previous string
                curr.insert(0, stack.pop());

            } else {
                // Add character
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}