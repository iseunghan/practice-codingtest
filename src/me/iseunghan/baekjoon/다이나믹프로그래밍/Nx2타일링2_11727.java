package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;

public class Nx2타일링2_11727 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];

        // init
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 3;
        }

        // 각 dp 배열에 10007로 나눈 나머지를 넣어줍니다.
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.print(dp[N]);
    }
}