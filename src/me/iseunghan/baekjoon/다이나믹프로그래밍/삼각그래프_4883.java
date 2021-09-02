package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 삼각그래프_4883 {
    static int cnt = 0;
    static int[][] dp;
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = bf.readLine();
        while (!input.equals("0")) {
            int N = Integer.parseInt(input);

            dp = new int[N][3];
            arr = new int[N][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            //init
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][1] + arr[0][2];

            // dp
            // (단, i >= 1) dp[i][0]은 dp[i-1][0], dp[i-1][1] 두가지가 있다.
            // dp[i][1]은 dp[i-1][0], dp[i-1][1], dp[i-1][2], dp[i][0] 네가지가 있다.
            // dp[i][2]은 dp[i-1][1], dp[i-2][2], dp[i][1] 세가지가 있다.
            // 가장 작은 것을 선택하면 됩니다.
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
                dp[i][1] = Math.min(Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]), dp[i][0]) + arr[i][1];
                dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i][1]) + arr[i][2];
            }

            input = bf.readLine();
            cnt++;

            bw.write(cnt + ". " + dp[N - 1][1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}