package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기_11052 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // init
        dp[1] = P[1];
        dp[2] = Math.max(P[2], dp[1] * 2);

        // 3부터 N까지
        for (int i = 3; i <= N; i++) {
            // i장 들은 카드팩 구입 가격을 MAX로 지정!
            int MAX = P[i];

            // i의 합이 될수있는 조합들을 살펴봅니다.
            int end = (int) Math.round(i / 2);    // 범위를 조금이나마 줄여보고자 불필요한 범위는 제외
            for (int j = i - 1; j >= end; j--) {
                // i를 j + i-j 로 나타낼 수 있다면,
                // dp에 저장된 값들을 더해서 MAX를 찾아냅니다.
                int val = dp[j] + dp[i - j];
                if (val > MAX) MAX = val;
            }
            // 최종적으로 dp[i]에는 MAX값이 담깁니다.
            dp[i] = MAX;
        }

        int result = 0;
        for (int i : dp) {
            if (i > result) result = i;
        }
        System.out.println(result);
    }
}