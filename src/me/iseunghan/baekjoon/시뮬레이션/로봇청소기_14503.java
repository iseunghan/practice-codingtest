package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 로봇청소기_14503 {
    // 참고: https://www.acmicpc.net/board/view/69846
    static int N, M;
    static int r, c, d, flag = 0, answer = 0;
    static int[] dx;
    static int[] dy;
    static int[] find;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Queue<int[]> qu = new LinkedList<>();

        find = new int[4];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        map = new int[51][51];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * 11;
            }
        }

        qu.offer(new int[]{r + 1, c + 1, d});

        // flag가 -1이거나, 큐가 비었으면 종료!
        while (!qu.isEmpty() && flag != -1) {

            int[] p = qu.poll();
            int r1 = p[0];
            int c1 = p[1];
            int d1 = p[2];

            // 1. 현위치를 청소한다.
            if (map[r1][c1] == 0) {
                map[r1][c1] = 10;
                answer++;
            }

            // 2. 현위치를 기준으로 왼쪽에 청소를 할 수 있는지 탐색!
            int[] arr = rotate(r1, c1, d1);

            if (map[arr[0]][arr[1]] == 0) {
                // 청소 O
                qu.offer(new int[]{arr[0], arr[1], arr[2]});
            } else {
                // 청소 X
                if (sum4(r1, c1, d1) >= 40) {
                    // 3. 4방향 모두 탐색했을 경우! -> 후진하기
                    int[] b = go_back(r1, c1, d1);

                    // 3-1. 뒤가 벽이라면 후진 불가능!
                    if (map[b[0]][b[1]] == 11) {
                        flag = -1;
                    } else {
                        // 3-2. 벽이 아니라면 후진 가능!
                        qu.offer(new int[]{b[0], b[1], b[2]});
                    }
                } else {
                    // 4. 4방향 중 청소할 곳이 남았다면?
                    int[] f = find_place(r1, c1, d1);
                    qu.offer(new int[]{f[0], f[1], f[2]});
                }
            }
        }
        System.out.print(answer);
    }

    // 바라보는 방향을 기준으로 왼쪽으로 회전하고 한칸 앞으로 진행시켜주는 메소드
    static int[] rotate(int x, int y, int d) {
        switch (d) {
            case 0:
                y--;
                d = 3;
                break;
            case 1:
                x--;
                d = 0;
                break;
            case 2:
                y++;
                d = 1;
                break;
            case 3:
                x++;
                d = 2;
                break;
        }
        return new int[]{x, y, d};
    }

    // 현위치 기준 4방향의 값을 더해주는 메소드
    static int sum4(int x, int y, int d) {
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            sum += map[x + dx[i]][y + dy[i]];
        }

        return sum;
    }

    // 뒤로 후진
    static int[] go_back(int x, int y, int d) {
        switch (d) {
            case 0:
                x++;
                break;
            case 1:
                y--;
                break;
            case 2:
                x--;
                break;
            case 3:
                y++;
                break;
        }
        return new int[]{x, y, d};
    }

    // 바라보는 방향을 기준으로 순차적으로 왼쪽을 탐색하며, 청소할 공간을 찾는다.
    static int[] find_place(int x, int y, int d) {
        switch (d) {
            case 0:
                find[0] = 3;
                find[1] = 2;
                find[2] = 1;
                find[3] = 0;
                break;
            case 1:
                find[0] = 0;
                find[1] = 3;
                find[2] = 2;
                find[3] = 1;
                break;
            case 2:
                find[0] = 1;
                find[1] = 0;
                find[2] = 3;
                find[3] = 2;
                break;
            case 3:
                find[0] = 2;
                find[1] = 1;
                find[2] = 0;
                find[3] = 3;
                break;
        }

        for (int i = 0; i < 4; i++) {
            if (map[x + dx[find[i]]][y + dy[find[i]]] == 0) {
                return new int[]{x + dx[find[i]], y + dy[find[i]], find[i]};
            }
        }
        return new int[]{x, y, d};
    }
}