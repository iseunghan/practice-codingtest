package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 안전영역_2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int MAX = -1;
        int MAX_H = 0;
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> qu = new LinkedList<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (MAX_H < arr[i][j]) MAX_H = arr[i][j];
            }
        }

        // 강수량 1부터 100까지 체크!
        for (int T = 0; T <= MAX_H; T++) {
            visit = new boolean[N][N];    // 새로 초기화
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] || arr[i][j] <= T) {
                        continue;
                    }

                    count++;    // 영역 개수 증가
                    qu.offer(new int[]{i, j});
                    visit[i][j] = true;    // 방문 완료!

                    // BFS
                    while (!qu.isEmpty()) {
                        int[] cur = qu.poll();

                        for (int k = 0; k < 4; k++) {
                            int nX = cur[0] + dx[k];
                            int nY = cur[1] + dy[k];

                            if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                            // 방문을 했거나, 물에 잠겼으면 PASS
                            if (visit[nX][nY] || arr[nX][nY] <= T) continue;

                            visit[nX][nY] = true;    // 방문 표시
                            qu.offer(new int[]{nX, nY});
                        }
                    }
                    if (MAX < count) MAX = count;    // 최대 영역 변경
                }
            }
        }
        // 정답 출력!
        System.out.print(MAX);
    }
}
