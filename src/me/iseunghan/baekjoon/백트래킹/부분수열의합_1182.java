package me.iseunghan.baekjoon.백트래킹;

import java.util.*;
import java.io.*;

public class 부분수열의합_1182 {
    static int N, K, answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dfs 시작
        dfs(0, 0);

        if (K == 0) System.out.print(answer - 1);   // 합이 0이라면 1을 빼줘야함!
        else System.out.print(answer);
    }

    static void dfs(int depth, int sum) {
        // 깊이가 다되면?
        if (depth == N) {
            // 원하는 합이 맞으면 answer + 1
            if (sum == K) {
                answer++;
            }
            return;
        }

        // (1) 현재 숫자를 계산했을 경우
        dfs(depth + 1, sum);
        // (2) 현재 숫자를 계산하지 않았을 경우
        dfs(depth + 1, sum + arr[depth]);
    }
}