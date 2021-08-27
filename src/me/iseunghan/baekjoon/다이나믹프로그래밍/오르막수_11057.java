package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;

public class 오르막수_11057 {
    static final int MOD = 10_007;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] dp = new long[N + 1][11];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }
        dp[1][10] = 10L; // sum

        // 2부터 DP
        for (int i = 2; i <= N; i++) {
            // 이전에 계산한 dp[i-1]의 합이 담겨있는 dp[i-1][10] 값을 가져옵니다.
            dp[i][0] = dp[i - 1][10];
            long sum = dp[i][0];
            for (int j = 1; j < 10; j++) {
                // 오버플로우! 모듈로 연산
                dp[i][j] = (dp[i][j - 1] % MOD - dp[i - 1][j - 1] % MOD) % MOD + MOD;
                sum += dp[i][j] % MOD;
            }
            // 오버플로우!
            dp[i][10] = sum % MOD;
        }
        System.out.print(dp[N][10] % 10007);
    }
}