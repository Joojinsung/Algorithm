# 👊[Algorithm]

![예시 이미지](src/image/360_F_336238925_A94Tnq3eLPTLM004nbjkzWhPMfShdjfd.jpg)

## 목차

- [1. 문제 : 포켓몬](#1-문제--포켓몬-1lv)
- [2. 문제 : 완주하지 못한 선수](#2-문제--완주하지-못한-선수-1lv)
- [3. 문제 : 같은 숫자는 싫어](#3-문제--같은-숫자는-싫어-1lv)
- [4. 문제 : K번째 수](#4-문제--k번째-수-1lv)
- [5. 문제 : 최소직사각형](#5-문제--최소직사각형-1lv)
- [6. 문제 : 모의고사](#6-문제--모의고사-1lv)
- [7. 문제 : 체육복](#7-문제--체육복-1lv)
- [8. 문제 : 전화번호 목록](#8-문제--전화번호-목록-2lv)
- [9. 문제 : 의상](#9-문제--의상-2lv)
- [10.문제 : 기능개발](#10문제--기능개발-2lv)
- [11.문제 : 올바른 괄호](#11문제--올바른-괄호-2lv)
- [12.문제 : 프로세스](#12문제--프로세스-2lv)
- [13.문제 : 다리를 지나는 트럭](#13문제--다리를-지나는-트럭-2lv)

## 1. 문제 : 포켓몬 1LV

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1845)

span

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
    for (String c : completion) {
        participantMap.put(c, participantMap.get(c) - 1);
    }

    //출현 횟수가 1이상인 참가자는 완주하지 못한 것
    for (Map.Entry<String, Integer> entry : participantMap.entrySet()) {
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

---

## 7. 문제 : 체육복 1LV

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42862)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        int count = 0;
        // 3,4
        // 3,4

        reserve = Arrays.stream(reserve).sorted().toArray();
        lost = Arrays.stream(lost).sorted().toArray();

        System.out.println(Arrays.toString(reserve));

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1]--;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                if (i > 0 && arr[i - 1] == 1) {
                    arr[i] = 0;
                    arr[i - 1] = 0;

                } else if (i < n - 1 && arr[i + 1] == 1) {
                    arr[i] = 0;
                    arr[i + 1] = 0;
                }
            }
        }
        for (int i : arr) {
            if (i >= 0) {
                count++;
            }
        }

        return count;
    }
}

```

</details>

---

## 8. 문제 : 전화번호 목록 2LV

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42577)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.Arrays;

class Solution {
    public boolean solution(String[] n1) {
        Arrays.sort(n1);
        for (int i = 1; i < n1.length; i++) {
            String preN = n1[i - 1]; // 이전 번호
            String currentN = n1[i]; //현재 번호

            if (currentN.startsWith(preN)) {
                return false;
            }
        }

        return true;
    }
}
```

</details>

---

## 9. 문제 : 의상 2Lv

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42578)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String category = cloth[1];
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        int combinations = 1;
        for (int count : map.values()) {
            combinations *= (count + 1);
        }
        return combinations - 1;
    }
}
```

</details>

---

## 10.문제 : 기능개발 2Lv

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42586)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.*;

class Solution {
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
```

</details>

---

## 11.문제 : 올바른 괄호 2Lv

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
import java.util.Stack;

class Solution {
    public boolean solution(String str) {
        Stack<String> stack = new Stack<>();

        if (str.charAt(str.length() - 1) == '(' || str.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(String.valueOf(str.charAt(i)));
            } else if (!stack.isEmpty()) {
                stack.pop();

            }
        }

        return stack.isEmpty();
    }
}
```

</details>

---

## 12.문제 : 프로세스 2Lv

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587)

<details>
<summary style="font-size: 15px">[풀이]</summary>

```java
public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {priorities[i], i});
        }
    
        int executionOrder = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigherPriority = false;
            for (int[] item : queue) {
                if (item[0] > current[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }
        
            if (hasHigherPriority) {
                queue.add(current);  
            } else {
                executionOrder++;  
                if (current[1] == location) { 
                    return executionOrder;
                }
            }
        }
        return -1;
    }
}
```

</details>

## 13.문제 : 다리를 지나는 트럭 2LV

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42583)

span

```java
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
      
        Queue<Integer> trucks = new LinkedList<>();
        for (int truck : truck_weights) {
            trucks.offer(truck);
        }
      
        int time = 0;
        int currentWeight = 0;
      
        while (!trucks.isEmpty() || currentWeight > 0) {
            time++;
            currentWeight -= bridge.poll();
          
            if (!trucks.isEmpty()) {
                if (currentWeight + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    bridge.offer(truck);
                    currentWeight += truck;
                } else {
                    bridge.offer(0);
                }
            } else {
                bridge.offer(0);
            }
        }
      
        return time;
    }
}
```

</details>
