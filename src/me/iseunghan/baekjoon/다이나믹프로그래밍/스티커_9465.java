package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 스티커_9465 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        int N = 0;
        int[][] arr;
        int[][][] dp;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(bf.readLine());

            arr = new int[2][N + 1];
            dp = new int[2][N + 1][2];


            for (int p = 0; p < 2; p++) {
                st = new StringTokenizer(bf.readLine());

                for (int i = 1; i <= N; i++) {
                    arr[p][i] = Integer.parseInt(st.nextToken());
                }
            }

            // 윗 변 초기값 설정
            dp[0][1][0] = 0;
            dp[0][1][1] = arr[0][1];
            // 밑 변 초기값 설정
            dp[1][1][0] = dp[0][1][1];
            dp[1][1][1] = dp[0][1][0] + arr[1][1];

            // dp 시작
            for (int n = 2; n <= N; n++) {
                // 윗 변 계산
                dp[0][n][0] = Math.max(dp[1][n - 1][0], dp[1][n - 1][1]);
                dp[0][n][1] = Math.max(dp[0][n - 1][0], dp[1][n - 1][1]) + arr[0][n];
                // 밑 변 계산
                dp[1][n][0] = Math.max(dp[0][n][0], dp[0][n][1]);
                dp[1][n][1] = dp[1][n - 1][0] + arr[1][n];
            }
            System.out.println(Math.max(dp[1][N][0], dp[1][N][1]));
        }
    }
}