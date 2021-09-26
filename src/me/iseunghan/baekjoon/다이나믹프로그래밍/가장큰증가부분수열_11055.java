package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 가장큰증가부분수열_11055 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[N + 1];
        int[] num = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            dp[i] = k;
            num[i] = k;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (num[i] < num[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + num[j]);
                }
            }
        }

        int MAX = 0;
        for (int i = 0; i < N; i++) {
            if (MAX < dp[i]) {
                MAX = dp[i];
            }
        }
        System.out.print(MAX);
    }
}