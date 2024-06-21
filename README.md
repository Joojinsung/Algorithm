# 👊1일 1 [Algorithm]

![예시 이미지](src/image/360_F_336238925_A94Tnq3eLPTLM004nbjkzWhPMfShdjfd.jpg)

## 목차
- [1. 문제 : 24.06.16 포켓몬](#1-문제--240616-포켓몬-1lv)
- [2. 문제 : 완주하지 못한 선수](#2-문제--완주하지-못한-선수-1lv)
- [3. 문제 : 같은 숫자는 싫어](#3-문제--같은-숫자는-싫어-1lv)
- [4. 문제 : K번째 수](#4-문제--k번째-수-1lv)
- [5. 문제 : 최소직사각형](#5-문제--최소직사각형-1lv)
- [6. 문제 : 모의고사](#6-문제--모의고사-1lv)

## 1. 문제 : 24.06.16 포켓몬 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1845)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 배열의 길이를 2로 나눈 값
        int select = nums.length / 2;
        // 중복되지 않는 포켓몬 종류 수와 선택할 수 있는 포켓몬 수 중 작은 값 반환
        return Math.min(set.size(), select);
    }
}
```
</details>

---

## 2. 문제 : 완주하지 못한 선수 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42576)
<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
public static void main(String[] args) {
    String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    String[] completion = {"josipa", "filipa", "marina", "nikola"};
    String result = Solution(participant, completion);

    System.out.println(result);

}

public static String Solution(String[] participant, String[] completion) {

    Map<String, Integer> participantMap = new HashMap<>();

    //참가자 명단 순회 이름의 출현 횟수를 기록
    for (String p : participant) {
        participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
    }

    // 완주자 명단 순회
    for(String c : completion) {
        participantMap.put(c, participantMap.get(c) - 1);
    }

    //출현 횟수가 1이상인 참가자는 완주하지 못한 것
    for(Map.Entry<String, Integer> entry : participantMap.entrySet()) {
        if (entry.getValue() > 0) {
            return entry.getKey();
        }
    }
    //참가를 완주한 사람이 없음
    return null;
}

```
</details>

---

## 3. 문제 : 같은 숫자는 싫어 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12906)


<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
public class Solution {
    public Stack<Integer> solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (Integer i : arr) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            if (!stack.peek().equals(i)) {
                stack.push(i);
            }

        }
        return stack;
    }
}
```
</details>

---
## 4. 문제 : K번째 수 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42748)


<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
class Solution {
    public ArrayList solution(int[] array, int[][] commands) {
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
```
</details>

---
## 5. 문제 : 최소직사각형 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86491)


<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
 class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;


        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            if (width > height) {
                maxWidth = Math.max(maxWidth, width); //10,12
                maxHeight = Math.max(maxHeight, height); //7,7
            } else {
                maxWidth = Math.max(maxWidth, height);
                maxHeight = Math.max(maxHeight, width); //8,

            }
        }
        System.out.println("width 의 값은 = " + maxWidth + " height 값은 = " + maxHeight);
        return maxWidth * maxHeight;
    }
}
```
</details>

---
## 6. 문제 : 모의고사 1LV
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42840)


<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
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
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] result1 = sol.solution(answers1);
        for (int r : result1) {
            System.out.print(r + " ");
        }
        System.out.println();

        int[] answers2 = {1, 3, 2, 4, 2};
        int[] result2 = sol.solution(answers2);
        for (int r : result2) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}

```
</details>