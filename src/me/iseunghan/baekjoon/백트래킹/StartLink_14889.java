package me.iseunghan.baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink_14889 {
    static int N;
    static int[][] status;
    static int[] team_star;
    static int[] team_Link;
    static boolean[] isUsed;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); // 축구 선수 인원
        team_star = new int[N / 2];
        team_Link = new int[N / 2];
        status = new int[N][N];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(MIN);
    }

    private static void dfs(int index) {
        if (index == N / 2) {
            int idx = 0;
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int i1 : team_star) {
                    if (i != i1) {
                        count++;
                    }
                }
                if (count == N / 2) {
                    team_Link[idx++] = i;
                }
            }
            check_team_stat();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                team_star[index] = i;
                dfs(index + 1);
                for (int j = i + 1; j < N; j++) {
                    isUsed[j] = false;
                }
            }
        }
    }

    private static void check_team_stat() {
        int result1 = 0;
        int result2 = 0;

        for (int i : team_star) {
            for (int j : team_star) {
                result1 += status[i][j];
            }
        }
        for (int i : team_Link) {
            for (int j : team_Link) {
                result2 += status[i][j];
            }
        }

        int n = result1 - result2;
        n = n >= 0 ? n : -n;
        MIN = Math.min(MIN, n);
    }
}