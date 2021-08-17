package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 구간합구하기4_11659 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 숫자를 저장하는 배열
        int[] num = new int[N + 1];
        // i번째까지의 합을 저장하는 배열
        int[] dp = new int[N + 1];

        st = new StringTokenizer(bf.readLine());

        // 입력된 숫자 저장
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // dp배열에 i번째 까지의 합을 저장해줍니다.
        dp[1] = num[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + num[i];
        }

        // 각 구간의 합을 계산하여 출력!
        for (int i = 0; i < M; i++) {
            int result = 0;

            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // start가 1인 경우를 대비해 예외 처리
            if (start > 1) {
                result = dp[end] - dp[start - 1];
            } else {
                result = dp[end];
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}