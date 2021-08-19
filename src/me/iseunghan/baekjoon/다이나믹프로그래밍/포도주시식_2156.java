package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식_2156 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        // init
        int MAX = arr[1];
        dp[1][0] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = 0;

        if (N >= 2) {
            dp[2][0] = dp[1][1];
            dp[2][1] = arr[2];
            dp[2][2] = dp[1][1] + arr[2];
            MAX = dp[2][2];
        }

        // dp
        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = Math.max(Math.max(dp[i - 2][1], dp[i - 2][2]), dp[i - 2][0]) + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];

            if (MAX < dp[i][0]) MAX = dp[i][0];
            if (MAX < dp[i][1]) MAX = dp[i][1];
            if (MAX < dp[i][2]) MAX = dp[i][2];
        }

        System.out.print(MAX);
    }
}