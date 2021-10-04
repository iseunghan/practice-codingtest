package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class 동전_9084 {
    static int N, M, answer;
    static int[] dp;
    static int[] num;
    static int[] count;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            answer = 0;
            N = Integer.parseInt(bf.readLine());
            num = new int[N + 1];

            st = new StringTokenizer(bf.readLine());

            for (int n = 0; n < N; n++) {
                num[n] = Integer.parseInt(st.nextToken());
            }

            dp = new int[10001];

            M = Integer.parseInt(bf.readLine());

            // dp!
            // 정의) 코인의 조합으로 i번째 수를 만들 수 있는 경우의 수 : dp[i]
            // 점화식) dp[i]는 dp[i-coin[N]] + dp[i] 이다.
            // i | 1, 2, 3, 4, 5, 6..
            // 2 | x  1  x  1  x  1
            // 3 | x  1  1  1  1  2
            // .................... 이런식으로 내려가다보면 완성!
            for (int i = 0; i < N; i++) {
                // 초기값!
                dp[num[i]]++;

                for (int j = num[i]; j <= 10000; j++) {
                    dp[j] += dp[j - num[i]];
                }
            }

            bw.write(dp[M] + "\n");
        }
        bw.flush();
        bw.close();
    }
}