package Algorithm.LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] answers1 = {1, 3, 2, 4, 2};
        int[] result1 = sol.solution(answers1);
        for (int r : result1) {
            System.out.print(r + " ");
        }


    }

    static class Solution {
        public int[] solution(int[] answers) {
            // 수포자들이 찍는 패턴
            int[] pattern1 = {1, 2, 3, 4, 5};
            int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            System.out.println(2 % 5 + "값");

            int[] scores = new int[3];

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == pattern1[i % pattern1.length]) {
                    scores[0]++;
                }
                if (answers[i] == pattern2[i % pattern2.length]) {
                    scores[1]++;
                }
                if (answers[i] == pattern3[i % pattern3.length]) {
                    scores[2]++;
                }
            }

            int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

            List<Integer> bestStudents = new ArrayList<>();
            for (int i = 0; i < scores.length; i++) {
                if (scores[i] == maxScore) {
                    bestStudents.add(i + 1);
                }
            }


            int[] result = new int[bestStudents.size()];
            for (int i = 0; i < bestStudents.size(); i++) {
                result[i] = bestStudents.get(i);
            }

            return result;
        }
    }
}
