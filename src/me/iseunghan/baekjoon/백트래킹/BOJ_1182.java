package me.iseunghan.baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int N, S, result;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) System.out.print(result - 1);
        else System.out.print(result);
    }

    public static void dfs(int depth, int num) {
        if (num == S) {
            result++;
            return;
        }
        if (depth == N) {
            return;
        }


        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, num + arr[i]);
                for (int j = i + 1; j < N; j++) {
                    visit[j] = false;
                }
            }
        }
    }
}