package Algorithm.Lv1;

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{10,7}, {12,3}, {8,15}, {14,7}, {5,15}};
        System.out.println(solution.solution(arr));
    }

    static class Solution {
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
}
