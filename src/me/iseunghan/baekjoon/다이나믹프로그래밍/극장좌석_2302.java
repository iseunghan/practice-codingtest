package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 극장좌석_2302 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int T = Integer.parseInt(bf.readLine());

        // init
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // vip석이 없다면 dp[N] 값 출력 후 종료
        if (T == 0) {
            System.out.print(dp[N]);
            System.exit(0);
        }

        // 전좌석이 vip석이라면 1 출력 후 종료
        if (T == N) {
            System.out.print(1);
            System.exit(0);
        }

        int[] vip = new int[T];

        // vip 좌석 번호 입력
        for (int i = 0; i < T; i++) {
            vip[i] = Integer.parseInt(bf.readLine());
        }

        // 첫 번째 좌석 그룹 경우의 수
        int result = dp[vip[0] - 1];

        // 첫 번째, 마지막 좌석 그룹 제외 경우의 수
        for (int i = 0; i < T - 1; i++) {
            result *= dp[vip[i + 1] - vip[i] - 1];
        }

        // 마지막 좌석 그룹 경우의 수
        result *= dp[N - vip[T - 1]];

        System.out.print(result);
    }
}