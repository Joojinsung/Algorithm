package 백준.bronze1;

import java.util.Scanner;

public class 팰린드롬수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int value = sc.nextInt();
            if (value == 0) break;

            String str = String.valueOf(value);
            boolean isPalindrome = true;

            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}