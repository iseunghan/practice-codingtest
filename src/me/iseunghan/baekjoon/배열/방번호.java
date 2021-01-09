package me.iseunghan.baekjoon.배열;

import java.util.Arrays;
import java.util.Scanner;

public class 방번호 {
    static int result = 0;
    static int[] arr = new int[10];    // 0 ~ 9

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("");

        buy_Set();

        for (String s1 : split) {
            int i = Integer.parseInt(s1);
            while (true) {
                if (arr[i] > 0) {
                    arr[i]--;
                    break;
                } else if (i == 6 || i == 9) {
                    /* 6 or 9 */
                    if (arr[6] > 0) {
                        arr[6]--;
                        break;
                    } else if (arr[9] > 0) {
                        arr[9]--;
                        break;
                    }
                    buy_Set();
                } else {
                    buy_Set();
                }
            }
        }
        System.out.println(result);
    }

    private static void buy_Set() {
        result++;

        for (int i = 0; i < 10; i++) {
            arr[i] += 1;
        }
    }
}
