package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.Scanner;

public class LCS_9251 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // init
        int MAX = 0;
        int[] flag = {0, 0, 0};
        String a = sc.nextLine();
        String b = sc.nextLine();
        int len = a.length();
        int len2 = b.length();

        // 넉넉하게 최대 범위로 잡는다.
        char[] arr = new char[1001];
        char[] arr2 = new char[1001];

        // input
        for (int i = 1; i <= len; i++) {
            arr[i] = a.charAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            arr2[i] = b.charAt(i - 1);
        }

        // dp 배열
        int[][] dp = new int[1001][1001];

        // dp
        // 자세한 풀이는 https://st-lab.tistory.com/139 참조..!
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr[i] == arr2[j]) {
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - 1][i]);
                }

                // MAX
                if (MAX < dp[j][i]) {
                    MAX = dp[j][i];
                }
            }
        }

        System.out.print(MAX);
    }
}