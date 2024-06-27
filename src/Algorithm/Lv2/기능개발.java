package Algorithm.Lv2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        ArrayList<Integer> a = solution.solution(progresses, speeds);
        System.out.println(a);
    }

    static class Solution {
        public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
            Queue<Integer> que = new LinkedList<>();
            ArrayList<Integer> result = new ArrayList<>();

            // 일자 계산
            for (int i = 0; i < progresses.length; i++) {
                int a = (100 - progresses[i]) % speeds[i];
                if (a > 0) {
                    int b = (100 - progresses[i]) / speeds[i];
                    que.offer(b + 1);
                } else {
                    que.offer((100 - progresses[i]) / speeds[i]);
                }
            }

            while (!que.isEmpty()) {
                int current = que.poll();
                int count = 1;
                while (!que.isEmpty() && current >= que.peek()) {
                    que.poll();
                    count++;
                }
                result.add(count);
            }
            return result;
        }
    }
}

// 처음 값 가져오고 삭제,
// 가져온 값이 더 크면 같이 배포. 아니면 다음값 가져옴
//  값 비교하며 count++ -> result.add

//2,7,9
//5,10,1,1,10,1

