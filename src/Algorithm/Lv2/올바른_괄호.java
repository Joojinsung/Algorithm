package Algorithm.Lv2;

import java.util.Objects;
import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "(())()";
        System.out.println(solution.solution(str));
    }

    static class Solution {
        public boolean solution(String str) {
            Stack<String> stack = new Stack<>();

            if (str.charAt(str.length() - 1) == '(' || str.charAt(0) == ')') {
                return false;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(String.valueOf(str.charAt(i)));
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }
}
