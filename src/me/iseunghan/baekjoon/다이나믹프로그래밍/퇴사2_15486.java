package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 퇴사2_15486 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // [0] = 최대 값의 인덱스 저장, [1] = 최대 값 저장
        int[] MAX = new int[2];

        // 1부터 탐색
        for (int i = 1; i <= N; i++) {
            // 오늘 상담이 끝나는 일 계산
            int next = i + T[i];

            // // 최대 값이라면 -> MAX배열에 인덱스와 최대 값 설정
            if (MAX[1] <= dp[i]) {
                MAX[0] = i;
                MAX[1] = dp[i];
            }

            // 만약 퇴사일+1에 끝난다면?
            if (next <= N + 1) {
                // 상담이 끝나는 날이 최대값의 인덱스보다 크거나 같다면,
                // i일 상담은 이익이 적다는 뜻이므로, 최대값 + P[i] 합을 dp[next] 에 넣어줍니다.
                if (i > MAX[0]) {
                    dp[next] = Math.max(dp[next], MAX[1] + P[i]);
                } else {
                    dp[next] = Math.max(dp[next], dp[i] + P[i]);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            if (result < i) result = i;
        }
        System.out.print(result);
    }
}