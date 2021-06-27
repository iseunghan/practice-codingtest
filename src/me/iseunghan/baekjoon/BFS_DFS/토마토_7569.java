package me.iseunghan.baekjoon.BFS_DFS;

// https://www.acmicpc.net/problem/7569

import java.util.*;
import java.io.*;

public class 토마토_7569 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int notYet = 0;
        int result = 0;

        int[][][] days = new int[H][N][M];        // 날짜를 계산하는 3차원배열
        int[][][] tomatos = new int[H][N][M];   // 토마토의 상태를 저장하는 3차원배열
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        Queue<Triple> qu = new LinkedList<>();

        for (int p = 0; p < H; p++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    tomatos[p][i][j] = Integer.parseInt(st.nextToken());
                    if (tomatos[p][i][j] == 1) {
                        qu.offer(new Triple(i, j, p));
                        days[p][i][j] = 0;
                    } else {
                        days[p][i][j] = -1;
                        if (tomatos[p][i][j] == 0) {
                            notYet++;
                        }
                    }
                }
            }
        }

        if (notYet == 0) {
            System.out.print(0);
            System.exit(0);
        }

        while (!qu.isEmpty()) {
            Triple t = qu.poll();

            for (int i = 0; i < 6; i++) {
                int nX = t.x + dx[i];
                int nY = t.y + dy[i];
                int nZ = t.z + dz[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M || nZ < 0 || nZ >= H) {
                    continue;
                }

                if (tomatos[nZ][nX][nY] == -1 || days[nZ][nX][nY] != -1) {
                    continue;
                }

                qu.offer(new Triple(nX, nY, nZ));
                notYet--;
                days[nZ][nX][nY] = days[t.z][t.x][t.y] + 1;

                if (days[nZ][nX][nY] > result) {
                    result = days[nZ][nX][nY];
                }
            }
        }

        if (notYet > 0) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }

    public static class Triple {
        int x, y, z;

        public Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }
}