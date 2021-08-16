package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;

public class 계단오르기_2579 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] score = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(bf.readLine());
        }

        // dp[i][1]는 i번째 계단을 1계단 연속으로 올라왔다는 뜻입니다. -> i-1을 밟지 않았다는 뜻!
        // dp[i][2]는 i번째 계단을 2계단 연속으로 올라왔다는 뜻입니다. -> i-1를 무조건 밟았다는 뜻!
        int[][] dp = new int[N + 1][3];

        // 초기값 세팅
        dp[1][1] = score[1];

        // 1이 입력되는 것을 방지하여 예외처리
        if (N >= 2) {
            dp[2][1] = score[2];
            dp[2][2] = score[1] + score[2];
        }

        // i번째 계단을 1연속으로 밟았다는 것은, i-2계단을 1연속으로 밟고 올라온 점수(dp[i-2][1])와, 2연속으로 밟고 올라온 점수(dp[i-2][2])중 가장 큰 점수를 선택하면 됩니다.
        // i번째 계단을 2연속으로 밟았다는 것은, i-1계단을 무조건 밟고 왔어야 하는데, i-1계단을 밟았을 당시에는 1연속으로 밟고 온 상태여야 합니다!
        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + score[i];
            dp[i][2] = dp[i - 1][1] + score[i];
        }

        System.out.print(Math.max(dp[N][1], dp[N][2]));
    }
}