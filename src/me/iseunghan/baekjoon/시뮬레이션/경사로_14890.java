package me.iseunghan.baekjoon.시뮬레이션;

import java.util.*;
import java.io.*;

public class 경사로_14890 {
    static boolean[] visit;
    static int[][] stairs;
    static int N, L, cur_X, cur_Y, flag, answer;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        answer = 0;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        stairs = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                stairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 행(가로) 계단을 탐색
        for (int i = 0; i < N; i++) {
            cur_Y = 0;
            flag = 1;
            visit = new boolean[N + 1];

            for (int j = 0; j < N - 1; j++) {
                if (stairs[i][j] > stairs[i][j + 1]) {
                    // 현재 계단이 높다면? 현재 기준으로 다음 계단들을 살펴본다.
                    row_stair(1, i, j, 1);
                } else if (stairs[i][j] < stairs[i][j + 1]) {
                    // 현재 계단이 낮다면? 현재 기준으로 이전 계단들을 살펴본다.
                    row_stair(1, i, j + 1, -1);
                }

                // result
                if (flag == -1) {
                    break;
                }
            }

            if (flag == 1) {
                answer++;
            }
        }

        // 2. 열(세로) 계단을 탐색
        for (int j = 0; j < N; j++) {
            cur_X = 0;
            flag = 1;
            visit = new boolean[N + 1];

            for (int i = 0; i < N - 1; i++) {
                // 현재 계단이 높다면? 현재 기준으로 다음 계단들을 살펴본다.
                if (stairs[i][j] > stairs[i + 1][j]) {
                    col_stair(1, i, j, 1);
                } else if (stairs[i][j] < stairs[i + 1][j]) {
                    // 현재 계단이 낮다면? 현재 기준으로 이전 계단들을 살펴본다.
                    col_stair(1, i + 1, j, -1);
                }

                // result
                if (flag == -1) {
                    break;
                }
            }

            if (flag == 1) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    // 1. 행(가로) 기준으로 볼 때!
    static void row_stair(int depth, int x, int y, int arrow) {

        if (depth == L + 1) {
            flag = 1;
            return;
        }

        // except : Out of Index
        cur_Y = y + depth * arrow;
        if (cur_Y < 0 || cur_Y >= N || visit[cur_Y]) {
            flag = -1;
            return;
        }

        if (stairs[x][y] - 1 == stairs[x][cur_Y]) {
            visit[cur_Y] = true; // 방문 표시
            row_stair(depth + 1, x, y, arrow);
        } else {
            flag = -1;
        }
    }

    // 2. 열(세로) 기준으로 볼 때!
    static void col_stair(int depth, int x, int y, int arrow) {

        if (depth == L + 1) {
            flag = 1;
            return;
        }

        // except : Out of Index
        cur_X = x + depth * arrow;
        if (cur_X < 0 || cur_X >= N || visit[cur_X]) {
            flag = -1;
            return;
        }

        if (stairs[x][y] - 1 == stairs[cur_X][y]) {
            visit[cur_X] = true;
            col_stair(depth + 1, x, y, arrow);
        } else {
            flag = -1;
        }
    }
}