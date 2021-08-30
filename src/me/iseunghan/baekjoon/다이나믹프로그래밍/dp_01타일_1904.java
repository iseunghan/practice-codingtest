package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class dp_01타일_1904 {
    static final int MOD = 15746;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[n + 1];

        // init
        dp[1] = 1L;
        if (n >= 2)
            dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            // 모듈러 연산 -> - 값 발생할 수 있으므로, MOD 더해주기!
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD + MOD;
        }

        System.out.print(dp[n] % MOD);
    }
}