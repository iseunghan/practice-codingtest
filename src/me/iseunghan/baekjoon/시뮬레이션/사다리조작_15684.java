package me.iseunghan.baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작_15684 {
    static int N, M, H, answer;
    static int[][] map;
    static int[][] temp;
    static int[][] lines;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        answer = 100;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[31][11];
        temp = new int[31][11];
        lines = new int[4][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 방향을 넣어준다.
            map[x][y] = 1;      // 오른쪽
            map[x][y + 1] = -1;   // 왼쪽
        }

        // 추가 가로선 없이 사다리타기에 성공했을 시 정답 출력 후 종료!
        temp = map;
        if (play()) {
            System.out.print(0);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            dfs(i, 0, 1, 1);
        }

        if (answer == 100) answer = -1;
        System.out.print(answer);
    }

    static void dfs(int L, int depth, int sX, int sY) {
        // L: 1, 2, 3개를 뽑는다.
        if (depth == L) {
            int count = 0;

            temp = new int[31][11];

            // copy
            for (int n = 1; n <= H; n++) {
                for (int m = 1; m <= N; m++) {
                    temp[n][m] = map[n][m];
                }
            }

            for (int i = 0; i < L; i++) {
                if (lines[i][0] == -1) continue;

                int x = lines[i][0];
                int y = lines[i][1];
//                System.out.println(x + ", " + y);
                temp[x][y] = 1;
                temp[x][y + 1] = -1;

                count++;
            }
//            System.out.println("---------");

            // 이미 최솟값을 구했다면 정답 출력하고 종료!
            if (answer < count) {
                System.out.println(answer);
                System.exit(0);
            }

            // 사다리타기를 성공했다면 최솟값을 정답에 넣기
            if (play()) {
                if (answer > count) {
                    answer = count;
                }
            }

            return;
        }

        // 범위
        int nX = sX;
        if (sY >= N) {
            nX++;
        }
        for (int i = nX; i <= H; i++) {
            for (int j = 1; j <= N - 1; j++) { // 범위 주의! N-1까지만!
                // 가로선을 그을 수 있다면?
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    lines[depth][0] = i;
                    lines[depth][1] = j;
                    dfs(L, depth + 1, i, j + 2);
                }
            }
        }
    }

    static boolean play() {
        for (int i = 1; i <= N; i++) {
            int x = 0;
            int y = i;

            // 1 라인 씩 사다리 타기를 한다.
            while (true) {
                x++;

                if (x < 0 || x > H || y < 0 || y > N) break;

                if (temp[x][y] == 1) {
                    y++;
                } else if (temp[x][y] == -1) {
                    y--;
                }
            }

            // 사다리타기가 끝나고 해당 i줄에 있는지 체크!
            if (y != i) {
                return false;
            }
        }
        // 중간에 false를 return하지 않았다는 것은 곧 성공을 의미한다.
        return true;
    }
}