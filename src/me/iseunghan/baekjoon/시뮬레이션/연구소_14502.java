package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 연구소_14502 {
    static int N, M, answer;
    static int[] dx;
    static int[] dy;
    static int[][] walls;
    static int[][] labs;
    static int[][] temp;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        walls = new int[3][2];
        labs = new int[9][9];
        temp = new int[9][9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                labs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.print(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == 3) {
            temp = new int[9][9];
            Queue<int[]> qu = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = labs[i][j];

                    if (labs[i][j] == 2) {
                        qu.offer(new int[]{i, j});
                    }
                }
            }

            System.out.println("------------");
            // 벽으로 채운다.
            for (int i = 0; i < 3; i++) {
                System.out.print(walls[i][0] + ", " + walls[i][1] + "\t");
                temp[walls[i][0]][walls[i][1]] = 1;
            }
            System.out.println();
            // bfs!
            while (!qu.isEmpty()) {
                int[] a = qu.poll();
                int x = a[0];
                int y = a[1];

                for (int i = 0; i < 4; i++) {
                    int nX = x + dx[i];
                    int nY = y + dy[i];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
                    if (temp[nX][nY] != 0) continue;

                    // temp[nX][nY] == 0 일 때만 처리
                    temp[nX][nY] = 2;   // 바이러스 감염
                    qu.offer(new int[]{nX, nY}); // 바이러스가 퍼진다.
                }
            }

            // 안전 영역 구하기
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 0) count++;
                }
            }

            if (answer < count) answer = count;

            return;
        }
        // 범위 초기화!
        // if(start_y == M) {
        //     start_x += 1;
        //     start_y = 0;
        // }

        for (int i = start; i < N*M; i++) {
            int x = i / M;
            int y = i % M;
            // 빈 칸만 벽을 세울 수 있다.
            if (labs[x][y] == 0) {
                walls[depth][0] = x;
                walls[depth][1] = y;

                dfs(depth + 1, i + 1);
            }
        }
    }
}
// 01 02 03 06
// 10 11 13 16
// 21 23 25 26