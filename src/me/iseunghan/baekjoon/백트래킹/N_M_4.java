package me.iseunghan.baekjoon.백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N_M_4 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 자연수의 범위
        M = sc.nextInt(); // 출력 할 개수

        visit = new boolean[N + 1];
        arr = new int[M];

        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int index) throws IOException {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                arr[index] = i;
                dfs(index + 1);
                // 자식 호출이 끝났으면, 현재 i값만 true, 나머지는 false
                visit[i] = true;
                for (int k = i + 1; k <= N; k++) {
                    visit[k] = false;
                }
            }
        }
    }
}