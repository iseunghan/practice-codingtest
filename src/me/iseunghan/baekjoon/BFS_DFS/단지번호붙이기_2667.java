package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        char[][] map = new char[N][N];
        int[][] visit = new int[N][N];
        Queue<Pair> qu = new LinkedList<>();

        int[] houses = new int[25 * 25 + 1];    // 이 부분** 중요.. 정답 배열은 25개 이상일 수 있음..
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '0') {
                    visit[i][j] = -1;   // 방문 필요 X
                }
                map[i][j] = s.charAt(j);

            }
        }
        int idx = 0;    // houses의 인덱스
        int count = 0;
        int house = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 1이 아니거나, 방문할 필요가 없을 경우 PASS
                if (map[i][j] != '1' || visit[i][j] == -1)
                    continue;

                qu.offer(new Pair(i, j));
                count++;    // 단지 개수
                house = 0;    // 집 개수 초기화
                visit[i][j] = -1;    // 방문 완료

                // BFS!
                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    house++;

                    for (int k = 0; k < 4; k++) {
                        int nX = p.x + dx[k];
                        int nY = p.y + dy[k];

                        if (nX < 0 || nX >= N || nY < 0 || nY >= N)
                            continue;

                        if (map[nX][nY] != '1' || visit[nX][nY] == -1)
                            continue;

                        visit[nX][nY] = -1;    // 방문 표시!
                        qu.offer(new Pair(nX, nY));// 큐에 넣기.
                    }
                }
                houses[idx++] = house;    // 집 개수 저장
            }
        }
        Arrays.sort(houses);    // 오름차순 정렬
        bw.write(count + "\n");

        for (int i : houses) {
            if (i != 0) {
                bw.write(i + "\n");
            }
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