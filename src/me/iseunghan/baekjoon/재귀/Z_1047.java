package me.iseunghan.baekjoon.재귀;

import java.util.*;
import java.io.*;

public class Z_1047 {
    static int N, r, c;
    static int count;
    static int[][] arr;
    static int[] dx, dy;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 변수 초기화 작업
        /**
         * dx[], dy[] 의 역할 가장 작은 2X2 배열의 방문을 위해
         *      - 예를들어, 2X2 배열의 각 시작점은 다음과 같다.
         *      (0,0) -> (0,1) -> (1,0) -> (1,1)
         */
        dx = new int[]{0, 0, 1, 1};
        dy = new int[]{0, 1, 0, 1};

        // 입력
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, n);
        // arr = new int[N][N];

        // 길이가 N이고 시작점의 좌표 x, y를 넣어서 재귀 호출 시작!
        recur(N, 0, 0);
    }

    static void recur(int len, int x, int y) {
        // 종료 조건 : 가장 작은 길이 2X2 배열이 되었을 때!

        if (len == 2) {
            // System.out.println(x + " , " + y);
            // 이전에 만들어둔 dx[], dy[] 배열을 이용해서 방문횟수 기록!
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                count++;
                if (nX == r && nY == c) {
                    System.out.print(count - 1);
                    System.exit(0);
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX1 = x + len / 2 * dx[i];
            int nX2 = x + len / 2 * (dx[i] + 1) - 1;
            int nY1 = y + len / 2 * dy[i];
            int nY2 = y + len / 2 * (dy[i] + 1) - 1;

            if (r >= nX1 && r <= nX2 && c >= nY1 && c <= nY2) {
                // System.out.println(nX1 + ", " + nY1);
                count = count + (len / 2 * len / 2 * i);
                // System.out.println("count : " + count);
                recur(len/2, nX1, nY1);
            }
        }
    }
}
/**
 * for (int i = 0; i < 4; i++) {
 *             int x1 = N / 2 * dx[i];
 *             int x2 = N / 2 * (1 + dx[i]) - 1;
 *             int y1 = N / 2 * dy[i];
 *             int y2 = N / 2 * (1 + dy[i]) - 1;
 *
 *             // 가장 큰 사분면중 어느곳에 해당되는지 찾기 위한 범위
 *             if (r >= x1 && r <= x2 && c >= y1 && c <= y2) {
 *                 System.out.println(i);
 *                 count = N * 2 * i;  //  해당 사분면의 시작점의 방문 횟수
 *                 recur(N / 2, x1, y1);
 *             }
 *         }
 */
/**
 * int N = (int) Math.pow(2, n);
 * int[][] arr = new int[N + 1][N + 1];
 * boolean[][] start = new boolean[N + 1][N + 1];
 * int[] dx = {0, 0, 1, 1};
 * int[] dy = {0, 1, 0, 1};
 * <p>
 * int count = 0;
 * for (int p = 1; p < N / 2; p = p + N / 2) { // 1, 3,
 * for (int i = p; i <= N; i = i + 2) {
 * for (int j = p; j <= N; j = j + 2) {
 * start[i][j] = true;
 * System.out.print(i + ", " + j + "   ");
 * }
 * System.out.println();
 * }
 * }
 * <p>
 * // 1,1 1,2 2,1 2,2
 * // 1~4 * 4번 총
 * for (int p = 1; p < N / 2; p = p + N / 2) { // 1, 5
 * for (int j)
 * }
 */