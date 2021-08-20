package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // dp 원소를 1로 초기화!
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // i번째를 기준으로 j번째의 수가 크다면 -> dp[i]+1값과 dp[j] 중 큰 값을 넣어줍니다.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        // 결과 값으로 dp[i] 중 가장 큰 값을 출력해줍니다.
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            if (MAX < dp[i]) MAX = dp[i];
        }

        System.out.print(MAX);
    }
}