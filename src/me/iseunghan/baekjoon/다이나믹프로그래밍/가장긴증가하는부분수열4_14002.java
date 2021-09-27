package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열4_14002 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MAX = 1;
        int N = Integer.parseInt(bf.readLine());

        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // i번쨰 수를 기준으로, i+1 ~ j번째 수까지 비교를 하면서
        // i번째 보다 큰 수의 dp[j]값을 dp[j] vs dp[i] + 1 중 큰 값으로 넣어준다.
        // 그리고 가장 큰 증가한 길이를 MAX에 저장시킨다.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (num[i] < num[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);

                    if (MAX < dp[j]) MAX = dp[j];
                }
            }
        }

        bw.write(MAX + "\n");
        int[] answer = new int[MAX + 1];
        int idx = MAX;
        // "증가하는 수열이 여러개일 경우 아무거나 출력한다" 라는 조건 때문에
        // 맨 뒤에서부터 MAX ~ 0까지 수를 answer 배열에 저장시키고 출력시키면 끝!
        for (int i = N - 1; i >= 0; i--) {
            if (idx == dp[i]) {
                answer[idx--] = num[i];
            }
            if (idx < 0) break;
        }

        for (int i = 0; i <= MAX; i++) {
            if (answer[i] == 0) continue;

            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}