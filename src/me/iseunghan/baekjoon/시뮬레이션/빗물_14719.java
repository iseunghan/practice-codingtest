package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 빗물_14719 {
    static int H, W;
    static int[] top;
    static int[][] block;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        top = new int[W + 1];
        block = new int[501][501];
        visit = new boolean[501][501];

        // 각 블럭 마다 최대 높이를 top 배열에 저장해둡니다.
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < W; i++) {
            int e = Integer.parseInt(st.nextToken());
            top[i] = e;

            for (int j = H - top[i]; j < H; j++) {
                block[j][i] = 1;
            }
        }

        Queue<Integer> qu = new LinkedList<>();      // BFS 사용
        Queue<int[]> target = new LinkedList<>();    // 빗물을 채울 때 사용

        // 가로 고정
        for (int j = 0; j < W; j++) {
            // 최대 높이부터 바닥까지
            for (int i = H - top[j]; i < H; i++) {
                int flag = 0;
                // 해당 블럭이 있다면
                if (block[i][j] == 1) {
                    visit[i][j] = true;    // 방문 처리
                    qu.offer(j);    // 큐 삽입

                    // BFS : 지정된 칸으로 부터 오른쪽으로 쭉 탐색해나가면서 벽에 부딪혔을 때만! 해당 칸들을 빗물로 채웁니다.
                    while (!qu.isEmpty()) {
                        int y = qu.poll();
                        int ny = y + 1;

                        // 범위를 벗어나거나, 방문했을 때는 PASS
                        if (ny >= W) continue;
                        if (visit[i][ny]) continue;

                        // 오른쪽으로 가다가 다른 블록에 부딪혔다면 flag 표시하고 종료!
                        if (block[i][ny] == 1) {
                            flag = 1;
                            break;
                        }

                        // 방문 처리, 큐 삽입, 빗물 채울 큐에도 삽입
                        visit[i][ny] = true;
                        qu.offer(ny);
                        target.offer(new int[]{i, ny});
                    }
                }
                // flag 표시가 됐다면 빗물을 채워보자.
                if (flag == 1) {
                    while (!target.isEmpty()) {
                        int[] a = target.poll();
                        block[a[0]][a[1]] = 2;    // 2: 빗물
                    }
                }
                // flag가 표시 안됐다면, 큐 초기화
                else {
                    target.clear();
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // System.out.print(block[i][j] + " ");
                if (block[i][j] == 2) answer++;
            }
            // System.out.println();
        }

        System.out.print(answer);
    }
}