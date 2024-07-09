package Algorithm.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        solution.solution(bridge_length, weight, truck_weights);


    }


    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();

            // 길이 만큼 넣음
            for (int i = 0; i < bridge_length; i++) {
                bridge.offer(0);
            }

            // 대긷트럭
            Queue<Integer> trucks = new LinkedList<>();
            for (Integer truck : truck_weights) {
                trucks.offer(truck);
            }

            int time = 0;
            // 다리 위 총 무게
            int currentWeight = 0;

            while (!trucks.isEmpty() || currentWeight > 0) {
                time++;
                // 하중 체크
                currentWeight -= bridge.poll();

                // 트럭 없으면
                if (!trucks.isEmpty()) {
                    // 다음 트럭이 올라갈 수 있는지
                    if (currentWeight + trucks.peek() <= weight) {
                        int truck = trucks.poll(); // 다음트럭
                        bridge.offer(truck);
                        currentWeight += truck;
                    } else {
                        bridge.offer(0);
                    }
                } else {
                    bridge.offer(0);  // 대기 트럭이 없으면 0을 추가
                }

            }
            return time;
        }
    }
}
