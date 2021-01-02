package me.iseunghan.baekjoon.백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class N_M_3 {
    static int M, N;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N + 1];

        recursion(0);
        bw.flush();
        bw.close();
    }

    public static void recursion(int n) throws IOException {
        if (n == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[n] = i;
            visit[i] = true;
            recursion(n + 1);
            visit[i] = false;
        }
    }
}