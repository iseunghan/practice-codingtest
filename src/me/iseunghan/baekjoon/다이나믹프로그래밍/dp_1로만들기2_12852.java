package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class dp_1로만들기2_12852 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        // dp[i][0] : i의 최소 연산 횟수, dp[i][1] : 사용한 연산을 저장합니다.
        int[][] dp = new int[N + 1][2];

        // 초기값 세팅
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
            dp[i][1] = 1;

            if (i % 3 == 0) {
                int diff = dp[i / 3][0] + 1;

                // 둘 중 최소 연산 횟수를  [i][0]에 저장하고, 연산 정보를 [i][1]에 저장합니다.
                if (dp[i][0] >= diff) {
                    dp[i][0] = diff;
                    dp[i][1] = 3;
                }
            }
            if (i % 2 == 0) {
                int diff = dp[i / 2][0] + 1;

                // 둘 중 최소 연산 횟수를  [i][0]에 저장하고, 연산 정보를 [i][1]에 저장합니다.
                if (dp[i][0] >= diff) {
                    dp[i][0] = diff;
                    dp[i][1] = 2;
                }
            }
        }

        bw.write(dp[N][0] + "\n");
        bw.write(N + " ");

        int result = N;

        // 연산 정보를 이용하여 1이 될 때까지 연산 결과를 출력합니다.
        while (result != 1) {
            result = calculator(result, dp[result][1]);
            bw.write(result + " ");
        }

        bw.flush();
        bw.close();
    }

    static int calculator(int n, int s) {
        switch (s) {
            case 1:
                return n - 1;
            case 2:
                return n / 2;
            case 3:
                return n / 3;
            default:
                return 1;
        }
    }
}