package Algorithm.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        solution.solution(priorities, location);

    }

    static class Solution {
        public int solution(int[] priorities, int location) {

            Queue<int[]> queue = new LinkedList<>();

            // 우선순위, 인덱스 저장
            for (int i = 0; i < priorities.length; i++) {
                queue.add(new int[]{priorities[i], i});
            }

            for (int[] ints : queue) {
                System.out.println(ints[0] + " " + ints[1]);
            }

            int count = 0;

            while (!queue.isEmpty()) {
                // 가장 앞의 값 가져와서
                int[] current = queue.poll();
                boolean checkBoolean = false;


                for (int[] item : queue) {
                    //큐에 남아 있는 프로세스 비교해서 우선순위가 높은게 있는지 확인함

                    if (item[0] > current[0]) {
                        checkBoolean = true;
                        break;
                    }
                }

                //1vs1=
                //a,
                // 높은게 있으면 위의 for 탈출 -> 다시 큐에 넣음
                // true -> queue 에 새로 넣어줌
                if (checkBoolean) {
                    queue.add(current);
                } else {
                    // 그렇지 않으면 count++;
                    count++;
                    //index == location 이면 count return
                    if (current[1] == location) {
                        return count;
                    }
                }
            }
            return -1;
        }
    }

}
