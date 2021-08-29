package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 동전1_2293 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];

        // init
        dp[0] = 1;

        // 1 , 2 , 5로 10을 만드는 조합
        // 동전들) 1 2 3 4 5 6 7 8 9 10
        // 1일떄)  1 1 1 1 1 1 1 1 1 1
        // 2일 때) 1 1 2 2 3 3 4 4 4 5  <-- dp[10]은 추가로 dp[10-2] 값을 가진다.
        // 여기서 점화식은 아래와 같이 나타낼 수 있다.
        // 동전 C가 있을 때, 동전 i를 만드는 조합은 dp[C] + dp[i-C] 입니다.
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(bf.readLine());

            for (int j = a; j <= k; j++) {
                dp[j] = dp[j] + dp[j - a];
            }
        }

        System.out.print(dp[k]);
    }
}