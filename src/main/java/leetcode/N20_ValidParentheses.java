package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by langji on 07/01/2020.
 *
 */
public class N20_ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        // switch, right bracket first
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty() || stack.pop() != map.get(c)) return false;
            }
        }

        return stack.empty();
    }

}
