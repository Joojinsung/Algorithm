package Algorithm.Lv2;

import java.util.*;

public class 의상 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] ans = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution.solution(ans);
    }

    static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();


            for (String[] cloth : clothes) {
                String category = cloth[1];
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            map.forEach((key, value) -> {
                System.out.println("key = " + key + " value = " + value);
            });

            // 곱 위해 1선언
            int combinations = 1;

            for (int count : map.values()) {

                combinations *= (count + 1); // 2, 3
                // 1*2, 2*3 = 6
                System.out.println("count = " + count + " combinations = " + combinations);
            }

            return combinations - 1;
        }
    }
}
