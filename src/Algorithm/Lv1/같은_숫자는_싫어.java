package Algorithm.Lv1;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Stack<Integer> result = solution.solution(arr);
        System.out.println("결과: " + result);
    }

    static class Solution {
        public Stack<Integer> solution(int[] arr) {
            Stack<Integer> stack = new Stack<>();

            for (int i : arr) {
                if (stack.isEmpty() || stack.peek() != i) {
                    stack.push(i);
                }
            }

            return stack;
        }
    }
}
