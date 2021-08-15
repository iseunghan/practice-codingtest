package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;

public class dp_123더하기_9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int[] dp = new int[12];

        // 1을 1,2,3으로 나타내는 방법은 1가지
        dp[1] = 1;
        // 2를 1,2,3으로 나타내는 방법은 2가지
        dp[2] = 2;
        // 3을 1,2,3으로 나타내는 방법은 4가지
        dp[3] = 4;
        // n을 1,2,3으로 나타내는 방법은 dp[n-1] + dp[n-2] + dp[n-3] 입니다.

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            sb.append(dp[Integer.parseInt(bf.readLine())] + "\n");
        }

        System.out.print(sb);
    }
}