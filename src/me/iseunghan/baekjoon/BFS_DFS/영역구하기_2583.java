package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 영역구하기_2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int area = 0;

        int[][] papers = new int[N][M];
        int[][] visit = new int[N][M];
        Queue<Pair> qu = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int n = x1; n < x2; n++) {
                for (int m = y1; m < y2; m++) {
                    papers[n][m] = 1;    // 해당 칸 채우기!
                    visit[n][m] = 1;    // 방문 완료 처리
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (papers[i][j] != 0 || visit[i][j] != 0) {
                    continue;
                }

                qu.offer(new Pair(i, j));    // 큐에 삽입!
                count++;            // 총 개수
                area = 0;
                visit[i][j] = 1;    // 방문 처리!

                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    area++;    // 개수 증가

                    for (int k = 0; k < 4; k++) {
                        int nX = p.x + dx[k];
                        int nY = p.y + dy[k];
                        // 벽에 부딪히거나, 범위를 넘어서면 PASS
                        if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                            continue;
                        }
                        // 해당 칸을 방문했거나, 색이 칠해져있으면 PASS
                        if(visit[nX][nY] != 0){
                            continue;
                        }

                        visit[nX][nY] = 1;    // 방문 완료 처리
                        qu.offer(new Pair(nX, nY));
                    }
                }
                list.add(area);
            }
        }
        bw.write(count + "\n");
        Collections.sort(list);
        for (int i : list){
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Pair{
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}