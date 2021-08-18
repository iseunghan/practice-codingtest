package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;

public class 피보나치함수_1003 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[][] dp = new int[41][2];

        // 초기값 설정
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        // fibonacci(3) = fibonacci(2) + fibonacci(1)의 공식을 이용하여 점화식 생성
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(bf.readLine());
            bw.write(dp[idx][0] + " " + dp[idx][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}