package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 불_4179 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int R = Integer.parseInt(st.nextToken());    // 행 개수
        int C = Integer.parseInt(st.nextToken());    // 열 개수

        char[][] miro = new char[R][C];// 미로 2차원 배열
        int[][] JM = new int[R][C];    // 지훈 시간
        int[][] FM = new int[R][C];    // 불 시간
        Queue<Pair> JQ = new LinkedList<>();  // 지훈(J) 큐
        Queue<Pair> FQ = new LinkedList<>();  // 불(F) 큐
        // 상하좌우 좌표
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 입력
        for (int i = 0; i < R; i++) {
            String s = bf.readLine();
            for (int j = 0; j < C; j++) {
                miro[i][j] = s.charAt(j);
                JM[i][j] = 10000;
                FM[i][j] = 10000;
                if (miro[i][j] == 'J') {
                    JM[i][j] = 0;    // 지훈이 위치에 0분 표시
                    JQ.offer(new Pair(i, j));  // 큐에 담아줌
                } else if (miro[i][j] == 'F') {
                    FM[i][j] = 0;
                    FQ.offer(new Pair(i, j));  // 큐에 넣어줌.
                }
            }
        }

        // 불 먼저 BFS 시작!
        while (!FQ.isEmpty()) {
            Pair FP = FQ.poll();  // 불 위치 꺼내기

            for (int i = 0; i < 4; i++) {
                int nx = FP.x + dx[i];
                int ny = FP.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (miro[nx][ny] == '#' || FM[nx][ny] != 10000) {
                    continue;
                }

                FM[nx][ny] = FM[FP.x][FP.y] + 1;
                FQ.offer(new Pair(nx, ny));
            }
        }

        // 지훈 BFS 시작!
        while (!JQ.isEmpty()) {
            Pair JP = JQ.poll();    // 지훈이 위치 꺼내기

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = JP.x + dx[i];
                int ny = JP.y + dy[i];

                // 만약, 범위를 벗어났다면
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    // 불이 나기전 이동을 했는지 시간을 비교한다
                    if (FM[JP.x][JP.y] <= JM[JP.x][JP.y]) {
                        continue;
                    }
                    // 탈출에 성공했다는 의미이니 시간 + 1 을 출력하고 종료!
                    System.out.print(JM[JP.x][JP.y] + 1);
                    System.exit(0);
                }

                if (miro[nx][ny] == '#' || JM[nx][ny] != 10000 || FM[JP.x][JP.y] <= JM[JP.x][JP.y]) {
                    continue;
                }

                JM[nx][ny] = JM[JP.x][JP.y] + 1;    // 이동 후 시간 증가
                JQ.offer(new Pair(nx, ny));    // 새로운 위치 큐에 넣어줌.
            }
        }
        // 실패 했다는 의미이니 불가능 출력!
        System.out.print("IMPOSSIBLE");

    }

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}