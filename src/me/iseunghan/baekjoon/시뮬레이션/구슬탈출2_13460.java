package me.iseunghan.baekjoon.시뮬레이션;

import java.util.*;
import java.io.*;

public class 구슬탈출2_13460 {
    static int N, M, answer;
    static boolean r_in_hole, b_in_hole;
    static int rX, rY, bX, bY;
    static int rcX, rcY, bcX, bcY;
    static int[] dx;
    static int[] dy;
    static int[] arrows;
    static char[][] temp;
    static char[][] board;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        answer = 1000;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        arrows = new int[10];
        board = new char[11][11];

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);

                /* R, B의 위치를 저장 */
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                }
                if (board[i][j] == 'B') {
                    bX = i;
                    bY = j;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            arrows[0] = i;
            dfs(1);
        }

        if (answer >= 100) {
            answer = -1;
        }
        System.out.print(answer);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            /* init */
            rcX = rX;
            rcY = rY;
            bcX = bX;
            bcY = bY;
            r_in_hole = false;
            b_in_hole = false;
            int count = 1000;

            /* copy array */
            temp = new char[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = board[i][j];
                }
            }

            // 지금까지 조합한 방향으로 보드를 기울여본다.
            for (int i = 0; i < 10; i++) {
                // 해당 방향으로 기울인다.
                rotate(arrows[i]);

                // 만약 B가 구멍으로 빠져나왔다면 실패
                if (b_in_hole) {
                    count = 100;
                    break;
                }
                // R이 구멍으로 빠져나왔다면 몇번 기울여서 빼냈는지 저장
                if (r_in_hole) {
                    count = i + 1;
                    break;
                }
            }
            // 가장 적은 값을 answer에 저장한다.
            if (count < answer) {
                answer = count;
            }

            return;
        }

        // 이전 방향에 따른 다음 방향을 지정해줍니다.
        // ex) 이전에 오른쪽으로 기울였다면, 굳이 또 오른쪽으로 기울이거나, 왼쪽으로 다시 되돌아갈 필요도 없습니다.
        // 그렇기 때문에 이전에 오른쪽으로 기울였다면, 다음 번에는 위, 아래 방향으로 기울이면 됩니다.
        switch (arrows[depth - 1]) {
            case 0:
                arrows[depth] = 1;
                dfs(depth + 1);
                arrows[depth] = 3;
                dfs(depth + 1);
                break;
            case 1:
                arrows[depth] = 0;
                dfs(depth + 1);
                arrows[depth] = 2;
                dfs(depth + 1);
                break;
            case 2:
                arrows[depth] = 3;
                dfs(depth + 1);
                arrows[depth] = 1;
                dfs(depth + 1);
                break;
            case 3:
                arrows[depth] = 2;
                dfs(depth + 1);
                arrows[depth] = 0;
                dfs(depth + 1);
                break;
        }
    }

    // 방향에 따라서 R, B가 둘 중 어느것을 먼저 기울여야 하는지 정하는 메소드
    // ex) 오른쪽으로 기울인다면, 만약  #.RB.# 이런식으로 있다면 B를 먼저 움직여야 R을 굴릴 수 있을 것이다.
    // 그렇기 때문에 방향에 따라서 어느 것을 먼저 굴려야 하는지 우선순위를 정해주어야 한다.
    static void rotate(int arrow) {
        switch (arrow) {
            case 0:
                if (rcX <= bcX) {
                    tilt_R(arrow);
                    tilt_B(arrow);
                } else {
                    tilt_B(arrow);
                    tilt_R(arrow);
                }
                break;
            case 1:
                if (rcY >= bcY) {
                    tilt_R(arrow);
                    tilt_B(arrow);
                } else {
                    tilt_B(arrow);
                    tilt_R(arrow);
                }
                break;
            case 2:
                if (rcX >= bcX) {
                    tilt_R(arrow);
                    tilt_B(arrow);
                } else {
                    tilt_B(arrow);
                    tilt_R(arrow);
                }
                break;
            case 3:
                if (rcY <= bcY) {
                    tilt_R(arrow);
                    tilt_B(arrow);
                } else {
                    tilt_B(arrow);
                    tilt_R(arrow);
                }
                break;
        }
    }

    // R을 기울여서 움직이는 메소드
    // '.'을 만나면 이동, '#' or 'B'를 만나면 break, 'O'를 만나면 홀인
    static void tilt_R(int i) {
        while (true) {
            if (temp[rcX + dx[i]][rcY + dy[i]] == '.') {
                temp[rcX][rcY] = '.';
                rcX += dx[i];
                rcY += dy[i];
                temp[rcX][rcY] = 'R';
            } else if (temp[rcX + dx[i]][rcY + dy[i]] == 'O') {
                temp[rcX][rcY] = '.';
                rcX += dx[i];
                rcY += dy[i];

                r_in_hole = true;
                break;
            } else {
                break;
            }
        }
    }

    // B를 기울여서 움직이는 메소드
    // '.'을 만나면 이동, '#' or 'R'를 만나면 break, 'O'를 만나면 홀인
    static void tilt_B(int i) {
        while (true) {
            if (temp[bcX + dx[i]][bcY + dy[i]] == '.') {
                temp[bcX][bcY] = '.';
                bcX += dx[i];
                bcY += dy[i];
                temp[bcX][bcY] = 'B';
            } else if (temp[bcX + dx[i]][bcY + dy[i]] == 'O') {
                temp[bcX][bcY] = '.';
                bcX += dx[i];
                bcY += dy[i];

                b_in_hole = true;
                break;
            } else {
                break;
            }
        }
    }
}