package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;

public class 파도반수열_9461 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        long[] dp = new long[101];

        // init
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < N; i++) {
            bw.write(dp[Integer.parseInt(bf.readLine())] + "\n");
        }
        bw.flush();
        bw.close();
    }
}