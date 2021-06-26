package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 토마토_7576 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int result = 0;      // 최종 날짜
        int notYet = 0;      // 안익은 토마토
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] days = new int[N][M];     // 날짜를 저장할 2차원배열
        int[][] tomatos = new int[N][M];  // 토마토의 상태를 저장할 2차원배열

        Queue<Pair> qu = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};    // 상하좌우 좌표 계산을 위한 배열
        int[] dy = {0, 1, 0, -1};


        // 토마토 상태 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                days[i][j] = -1;  // 방문여부를 위해 -1로 초기화
                int num = Integer.parseInt(st.nextToken());
                tomatos[i][j] = num;
                if (num == 1) {
                    qu.offer(new Pair(i, j)); // 익은 토마토만 큐에 넣어준다.
                    days[i][j] = 0;           // 해당 날짜 0일으로 세팅
                } else if (num == 0) {
                    notYet++;     // 익지 않은 토마토 +1
                }
            }
        }

        // 안익은 토마토가 없다면 종료.
        if (notYet == 0) {
            System.out.print(0);
            System.exit(0);
        }

        // 익은 토마토가 만약 n개 일때, 걸린 날짜 / n 인가?
        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            // 상하좌우 순회
            for (int i = 0; i < 4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                // 토마토가 없거나, 이미 방문했으면 PASS!
                if (tomatos[nX][nY] == -1 || days[nX][nY] != -1) {
                    continue;
                }
                // 익은 토마토를 큐에 넣어주고, 안익은 토마토의 개수 -1
                qu.offer(new Pair(nX, nY));
                notYet--;
                // 날짜를 +1 하여 넣어줍니다.
                days[nX][nY] = days[p.x][p.y] + 1;
                // 해당 날짜가 최종 날짜인지 구분
                if (result < days[nX][nY]) {
                    result = days[nX][nY];
                }
            }
        }

        // 만약 아직도 익지 않은 토마토가 있다면 -1 출력!
        if (notYet > 0) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
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

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}