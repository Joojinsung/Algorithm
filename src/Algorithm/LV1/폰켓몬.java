package Algorithm.LV1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(a));
    }

    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num);
            }
            // nums.length / 2 = 선택할 수 있는 폰켓몬의 수
            int select = nums.length / 2;
            // set.size()와 select 중 작은 값을 반환
            return Math.min(set.size(), select);
        }
    }
}

