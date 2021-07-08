package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 적록색약_10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> qu = new LinkedList<>();

        int cnt1 = 0, cnt2 = 0;    // 적록색약이 아닌사람과 색약인 사람이 본 구역의 수
        char[][] pictures = new char[N][N];
        boolean[][] visit_1 = new boolean[N][N];    // 적록색약 아닌 사람의 방문여부
        boolean[][] visit_2 = new boolean[N][N];    // 적록색약 인 사람의 방문여부

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < N; j++) {
                pictures[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // (1) 적록색약이 아닌 사람이 그림을 볼 때
                if (visit_1[i][j]) {
                    continue;
                } else {
                    cnt1++;              // 적록색약이 아닌 사람의 구역의 수 증가
                    visit_1[i][j] = true;// 방문 완료!
                    qu.offer(new int[]{i, j});

                    // 적록색약이 아닌 사람의 BFS!
                    while (!qu.isEmpty()) {
                        int[] arr = qu.poll();

                        for (int k = 0; k < 4; k++) {
                            int nX = arr[0] + dx[k];
                            int nY = arr[1] + dy[k];

                            if (nX < 0 || nX >= N || nY < 0 || nY >= N)
                                continue;

                            if (visit_1[nX][nY] || pictures[nX][nY] != pictures[arr[0]][arr[1]]) {
                                continue;
                            }
                            visit_1[nX][nY] = true;          // 방문 완료!
                            qu.offer(new int[]{nX, nY});    // 다시 큐에 넣기!
                        }
                    }
                }

                // (2) 적록색약인 사람이 그림을 볼 때
                if (visit_2[i][j]) {
                    continue;
                } else {
                    cnt2++;              // 적록색약인 사람의 구역의 수 증가
                    visit_2[i][j] = true;// 방문 완료!
                    qu.offer(new int[]{i, j});

                    // 적록색약인 사람의 BFS!
                    while (!qu.isEmpty()) {
                        int[] arr = qu.poll();

                        for (int k = 0; k < 4; k++) {
                            int nX = arr[0] + dx[k];
                            int nY = arr[1] + dy[k];

                            if (nX < 0 || nX >= N || nY < 0 || nY >= N)
                                continue;

                            if (visit_2[nX][nY]) {
                                continue;
                            }
                            if (pictures[nX][nY] != pictures[arr[0]][arr[1]]) {
                                // Blue 일때만 PASS!
                                if (pictures[arr[0]][arr[1]] == 'B' || pictures[nX][nY] == 'B') {
                                    continue;
                                }
                            }
                            visit_2[nX][nY] = true;          // 방문 완료!
                            qu.offer(new int[]{nX, nY});    // 다시 큐에 넣기!
                        }
                    }
                }
            }
        }
        System.out.print(cnt1 + " " + cnt2);
    }
}