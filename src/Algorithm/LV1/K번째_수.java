package Algorithm.LV1;

import java.util.ArrayList;
import java.util.Arrays;

public class K번째_수 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 입력
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        ArrayList<Integer> result = solution.solution(array, commands);
        System.out.println("결과: " + result);
    }

    static class Solution {
        public ArrayList<Integer> solution(int[] array, int[][] commands) {
            ArrayList<Integer> answer = new ArrayList<>();

            for (int i = 0; i < commands.length; i++) {
                // 자르기
                int[] copyArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
                // 정렬
                int[] sortArray = Arrays.stream(copyArray).sorted().toArray();
                if (commands[i][2] == 1) {
                    answer.add(sortArray[0]);
                } else {
                    answer.add(sortArray[commands[i][2] - 1]);
                }
            }
            return answer;
        }
    }
}
