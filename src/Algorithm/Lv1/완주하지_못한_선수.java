package Algorithm.Lv1;
import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        Solution solution = new Solution();
        String result = solution.solution(participant, completion);

        System.out.println(result);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> participantMap = new HashMap<>();

            // 참가자 명단 순회 이름의 출현 횟수를 기록
            for (String p : participant) {
                participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
            }

            // 완주자 명단 순회
            for (String c : completion) {
                participantMap.put(c, participantMap.get(c) - 1);
            }

            // 출현 횟수가 1 이상인 참가자는 완주하지 못한 것
            for (Map.Entry<String, Integer> entry : participantMap.entrySet()) {
                if (entry.getValue() > 0) {
                    return entry.getKey();
                }
            }

            // 참가를 완주한 사람이 없음 (이 경우는 발생하지 않아야 함)
            return "";
        }
    }
}