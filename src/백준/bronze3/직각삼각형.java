package 백준.bronze3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 직각삼각형 {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();

        int max;

        while (true) {
            max = 0;
            for (int i = 0; i < 3; i++) {
                arr.add(sc.nextInt());
            }

            if (arr.get(0) == 0 && arr.get(1) == 0 && arr.get(2) == 0) {
                break;
            }

            max = arr.stream().max(Integer::compare).get();

            arr.remove(arr.indexOf(max));

            if (Math.pow(max, 2) == Math.pow(arr.get(0), 2) + Math.pow(arr.get(1), 2)) {
                result.add("right");
            } else {
                result.add("wrong");
            }
            arr.clear();

        }


        for (String s : result) {
            System.out.println(s);
        }
    }
}


