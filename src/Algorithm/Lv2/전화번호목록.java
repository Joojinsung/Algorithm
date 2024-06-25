package Algorithm.Lv2;

import java.util.Arrays;


public class 전화번호목록 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] n1 = {"132", "13", "134"};


        System.out.println(solution.solution(n1));
    }

    static class Solution {
        public boolean solution(String[] n1) {
            Arrays.sort(n1);
            for (int i = 1; i < n1.length; i++) {
                String preN = n1[i-1]; // 이전 번호
                String currentN = n1[i]; //현재 번호

                if(currentN.startsWith(preN)) {
                    return false;
                }
            }

            return true;
        }
    }
}