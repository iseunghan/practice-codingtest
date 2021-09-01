package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.Scanner;

public class 피보나치수의확장_1788 {
    static final int MOD = 1_000_000_000;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();

        int[] dp = new int[2_000_001];

        // init
        dp[1_000_000 - 1] = 1;
        dp[1_000_000] = 0;
        dp[1_000_001] = 1;

        for (int i = 1_000_000 - 2; i >= 0; i--) {
            dp[i] = (dp[i + 2] % MOD - dp[i + 1] % MOD) % MOD;
        }

        for (int i = 1_000_002; i <= 2_000_000; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD + MOD;
        }

        int output = dp[n + 1_000_000] % MOD;

        if (output < 0) {
            result = -1;
            output *= -1;
        } else if (output == 0) {
            result = 0;
        } else {
            result = 1;
        }

        System.out.println(result);
        System.out.print(output);
    }
}