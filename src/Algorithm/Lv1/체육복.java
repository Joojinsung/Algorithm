package Algorithm.Lv1;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int[] lost = {1, 2, 3, 4, 5, 6};
        int[] reserve = {1, 2, 3};

        System.out.println("최종값 = " + solution.solution(n, lost, reserve));
    }

    static class Solution {
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
}
//2,4 / 3
//
//0,-1, 1,-1,0
//
// 1. -1일 경우 앞뒤가 1 인지 체크한다.
// 2. 1이 있을 경우 로직에 따라서 -- 또는 ++
// 3. 0, 1의 총 카운트
