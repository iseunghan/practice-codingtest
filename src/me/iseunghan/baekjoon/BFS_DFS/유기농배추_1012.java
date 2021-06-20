package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 유기농배추_1012 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());  // 테스트 케이스 개수
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> qu = new LinkedList<>();
        StringTokenizer st;
        int M = 0;
        int N = 0;
        int K = 0;
        int a = 0;
        int b = 0;
        int count = 0;
        // 테스트 케이스 만큼 반복!
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            count = 0;          // 필요한 지렁이 개수
            int[][] arr = new int[M][N];  // 배추 밭 배열
            int[][] visit = new int[M][N];// 방문 확인 배열

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(bf.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;    // 배추 표시
                visit[a][b] = 1;  // 방문 필요 표시
            }

            // BFS 시작!
            for (int p = 0; p < M; p++) {
                for (int q = 0; q < N; q++) {
                    // 배추가 없거나, 방문 하지 않아도 된다면 PASS
                    if (arr[p][q] != 1 || visit[p][q] != 1) {
                        continue;
                    }
                    // 큐에 배추 위치 삽입
                    qu.offer(new Pair(p, q));
                    count++;  // 지렁이 개수 + 1

                    // 인접한 배추 탐색!
                    while (!qu.isEmpty()) {
                        Pair pair = qu.poll();        // 탐색할 배추 위치 poll

                        // 상하좌우 탐색!
                        for (int z = 0; z < 4; z++) {
                            int nX = pair.x + dx[z];
                            int nY = pair.y + dy[z];

                            // 벽에 넘어갔거나, 범위를 벗어난 위치면 PASS
                            if (nX < 0 || nX >= M || nY < 0 || nY >= N) {
                                continue;
                            }
                            // 배추가 없거나, 방문이 필요하지 않으면 PASS
                            if (arr[nX][nY] != 1 || visit[nX][nY] != 1) {
                                continue;
                            }
                            // 다음 배추 위치 큐에 삽입
                            visit[nX][nY] = 0;
                            qu.offer(new Pair(nX, nY));
                        }
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}