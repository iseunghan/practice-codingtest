package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 주사위굴리기_14499 {
    static int cur_x, cur_y, N, M, K;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] dice;
    static int[][] map;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cur_x = Integer.parseInt(st.nextToken());
        cur_y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dice = new int[4][3];
        map = new int[21][21];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int temp_x = cur_x + dx[cmd];
            int temp_y = cur_y + dy[cmd];

            // 범위를 벗어난다면 PASS!
            if (temp_x < 0 || temp_x >= N || temp_y < 0 || temp_y >= M) {
                continue;
            }

            cur_x = temp_x;
            cur_y = temp_y;

            // 주사위 재배치
            rebase_dice(cmd);
            // 굴렸을 때의 로직 실행
            roll_dice(cmd);

            // 항상 [1][1]이 하늘을 바라보고 있다.
            bw.write(dice[1][1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    // 동(1), 서(2), 북(3), 남(4) 방향으로 굴렸을 때
    static void roll_dice(int arrow) {

        // 0일 때, 주사위 바닥면 -> 맵으로 복사
        if (map[cur_x][cur_y] == 0) {
            map[cur_x][cur_y] = dice[3][1];
        }
        // 0이 아닐 때, (1) 맵 -> 주사위 바닥면으로 복사 (2) 맵은 0으로 설정!
        else {
            dice[3][1] = map[cur_x][cur_y];
            map[cur_x][cur_y] = 0;
        }
    }

    // 방향에 따라 주사위의 눈을 재배치 해주는 메소드입니다.
    // (힌트) 노트에 그려서 보면 쉬움. 주사위를 굴렸을 때, 바닥면, 윗면, 동쪽을 향하는 면 .. 등등 인덱스를 잘 살펴보면 규칙이 보임.
    static void rebase_dice(int arrow) {
        int temp = 0;
        switch (arrow) {
            case 1:
                temp = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = temp;
                break;
            case 2:
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            case 3:
                temp = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = temp;
                break;
            default:
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
        }
    }
}