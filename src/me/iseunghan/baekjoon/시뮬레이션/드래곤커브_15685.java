package me.iseunghan.baekjoon.시뮬레이션;

import java.util.*;
import java.io.*;

public class 드래곤커브_15685 {
    static int[] dp;
    static int[] dx;
    static int[] dy;
    static int nX, nY, N;
    static int[][] map;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        map = new int[1025][1025];
        dp = new int[1025];
        dx = new int[]{1, 1, 0};
        dy = new int[]{0, 1, 1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            generate_arrow(x, y, d, g);
        }

        // (마지막 순서) 이전에 표시시킨 map 배열을 순회하면서 사각형의 개수를 구합니다.
        int answer = get_square();

        System.out.print(answer);
    }

    // 해당 시작 방향을 기준으로 10세대까지의 값을 미리 구해 놓는다.
    static void generate_arrow(int x, int y, int d, int g) {

        // dp 초기값
        dp[0] = d;

        // 10세대까지 dp 점화식을 이용하여 구한다.
        // 점화식 해석 : 0, | 1, | 2, 1, | 2, 3, 2, 1, | ....
        // 위 숫자들을 보면 [0] + 1 = [1]의 값이 된다.
        // "|"를 기준으로 대칭된 왼쪽의 수 + 1을 해준 것은 오른쪽 수가 된다.
        // 이때, 방향은 0, 1, 2, 3까지 이므로 % 4를 해줘야 한다.
        for (int i = 1; i <= 10; i++) {
            int pow = (int) Math.pow(2, i - 1);
            for (int j = pow; j < pow * 2; j++) {
                dp[j] = (dp[pow * 2 - 1 - j] + 1) % 4;
            }
        }

        nX = x;
        nY = y;
        map[nX][nY] = 1;

        // 해당 세대의 대한 방향들을 이용해서 map 배열에 표시를 해준다.
        int gen = (int) Math.pow(2, g);
        for (int i = 0; i < gen; i++) {
            rotate(dp[i]);
            map[nX][nY] = 1;
        }
    }

    // 방향 전환을 해주는 메소드
    // 방향에 맞게 좌표 값을 변경!
    static void rotate(int arrow) {
        switch (arrow) {
            case 0:
                nX++;
                break;
            case 1:
                nY--;
                break;
            case 2:
                nX--;
                break;
            case 3:
                nY++;
                break;
        }
    }

    // 사각형을 찾아주는 메소드
    // 0    1
    // 2    3   (0을 기준으로 1, 2, 3이 값이 1이라면 사각형이다.)
    static int get_square() {
        int result = 0;

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                int cnt = 0;

                if (map[i][j] != 1) continue;

                for (int p = 0; p < 3; p++) {
                    int oX = i + dx[p];
                    int oY = j + dy[p];

                    if (oX > 100 || oY > 100) continue;
                    if (map[oX][oY] != 1) continue;

                    cnt++;
                }
                if (cnt == 3) result++;
            }
        }

        return result;
    }
}