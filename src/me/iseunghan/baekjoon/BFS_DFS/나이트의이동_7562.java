package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 나이트의이동_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
        int[] dy = {1, -1, 2, -2, -1, 1, -2, 2};
        int[][] arr = {};   // 체스판 배열
        int[][] dist = {};  // 거리 재는 배열
        int s_X = 0, s_Y = 0, e_X = 0, e_Y = 0;    // 출발, 끝 좌표
        Queue<Pair> qu = new LinkedList<>();

        int T = Integer.parseInt(bf.readLine());
        // 테스트 케이스 만큼 반복
        for (int t = 0; t < T; t++) {
            int I = Integer.parseInt(bf.readLine());    // 체스판의 크기 입력받기
            arr = new int[I][I];    // 배열 생성
            dist = new int[I][I];

            st = new StringTokenizer(bf.readLine());
            s_X = Integer.parseInt(st.nextToken());
            s_Y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            e_X = Integer.parseInt(st.nextToken());
            e_Y = Integer.parseInt(st.nextToken());

            // 시작점과 끝점이 같다면 0출력하고 건너뜀!
            if (s_X == e_X && s_Y == e_Y) {
                bw.write("0\n");
                continue;
            }

            qu.offer(new Pair(s_X, s_Y));    // 시작점 세팅

            // BFS!
            while (!qu.isEmpty()) {
                Pair p = qu.poll();

                // 나이트의 모든 이동경로를 다 계산한다.
                for (int q = 0; q < 8; q++) {
                    int nX = p.x + dx[q];
                    int nY = p.y + dy[q];

                    // 만약, 벽에 부딪히거나 범위를 벗어난다면 PASS
                    if (nX < 0 || nX >= I || nY < 0 || nY >= I) {
                        continue;
                    } // 이미 방문했다면 PASS (거리가 계산됐다는 건 -> 방문한것)
                    if (dist[nX][nY] != 0) {
                        continue;
                    }

                    dist[nX][nY] = dist[p.x][p.y] + 1;    // 거리 + 1

                    // 끝 점에 도달했을 경우! BREAK!
                    if (nX == e_X && nY == e_Y) {
                        break;
                    } else {
                        qu.offer(new Pair(nX, nY));
                    }
                }
            }
            bw.write(dist[e_X][e_Y] + "\n");
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