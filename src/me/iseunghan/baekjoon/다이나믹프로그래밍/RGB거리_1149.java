package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class RGB거리_1149 {
    public static void main(String args[]) throws IOException {
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(bf.readLine());

        // 각 N개의 집의 [0]: R, [1]: G, [2]: B 의 비용이다.
        int[][] costs = new int[N + 1][3];

        // cost 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N번째 집이 어떤 색을 칠했는지 저장하는 배열
        int[][] dp = new int[N + 1][3];


        // 초기값 세팅
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        // 현재 칠하는 색과 '다른 두개의 색'으로 이전 집을 칠했을 때의 최소 비용을 찾아서 현재 비용과 더해줍니다.
        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        // 마지막 집에 각 색상을 칠했을 때의 최소비용을 출력합니다.
        System.out.print(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}