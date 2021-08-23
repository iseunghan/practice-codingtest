package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;

public class dp_123더하기3_15988 {
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        long[][] dp = new long[1_000_001][4];

        // init
        dp[1][1] = 1L;
        dp[2][1] = 1L;
        dp[2][2] = 1L;
        dp[3][1] = 2L;
        dp[3][2] = 1L;
        dp[3][3] = 1L;

        // dp : 점화식 -> dp[i][1]은 dp[i-1][1] + dp[i-2][1] + dp[i-3][1]과 같습니다.
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i][1] = (dp[i - 1][1] % MOD + dp[i - 2][1] % MOD + dp[i - 3][1] % MOD) % MOD;
            dp[i][2] = (dp[i - 1][2] % MOD + dp[i - 2][2] % MOD + dp[i - 3][2] % MOD) % MOD;
            dp[i][3] = (dp[i - 1][3] % MOD + dp[i - 2][3] % MOD + dp[i - 3][3] % MOD) % MOD;
        }

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(bf.readLine());
            long result = ((dp[input][1] + dp[input][2]) % MOD + dp[input][3]) % MOD;
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}