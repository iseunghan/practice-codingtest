package me.iseunghan.baekjoon.백트래킹;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_M_5 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] visit;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        visit = new boolean[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int index) throws IOException {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer[index] = arr[i];
                dfs(index + 1);
                visit[i] = false;
            }
        }
    }
}
