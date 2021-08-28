package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 감시_15683 {
    static int N, M;
    static int cctv_cnt = 0;
    static int MIN = 100;
    static int[] dx;
    static int[] dy;
    static int[] arrows;
    static int[][] arr;
    static int[][] copyArr;
    static int[][] cctv = new int[8][3];

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 순서대로 상,하,좌,우
        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // CCTV 위치 저장
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctv[cctv_cnt][0] = i;
                    cctv[cctv_cnt][1] = j;
                    cctv_cnt++;
                }
            }
        }

        // 방향을 저장하는 배열
        arrows = new int[cctv_cnt];

        // 모든 원소를 순회하면서 -> CCTV 방향 체크
        dfs(0);

        // 정답 출력
        System.out.print(MIN);
    }

    // dfs 시작!
    static void dfs(int depth) {
        // 종료 조건: 모든 CCTV의 방향을 다 조합했을 때!
        if (depth == cctv_cnt) {
            // 방문 체크할 배열 생성
            copyArr = new int[N][M];

            // 기존 배열 값 깊은 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyArr[i][j] = arr[i][j];
                }
            }

            // 현재까지 조합한 방향을 가지고 사각지대 찾기!
            for (int i = 0; i < cctv_cnt; i++) {
                detection(cctv[i][0], cctv[i][1], arrows[i]);
            }

            // 사각지대(=0)인 부분 개수 카운트!
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyArr[i][j] == 0) {
                        count++;
                    }
                }
            }
            // 최솟값 저장
            if (MIN > count) MIN = count;

            return;
        }

        for (int i = 0; i < 4; i++) {
            arrows[depth] = i;
            dfs(depth + 1);
        }
    }

    // 사각지대 찾기 위한 메소드
    static void detection(int i, int j, int arrow) {

        switch (arr[i][j]) {
            // 상, 하, 좌, 우
            case 1:
                switch (arrow) {
                    case 0:
                        check_place(i, j, 0);
                        break;
                    case 1:
                        check_place(i, j, 1);
                        break;
                    case 2:
                        check_place(i, j, 2);
                        break;
                    case 3:
                        check_place(i, j, 3);
                        break;
                }
                break;

            // 상하, 좌우, 상하, 좌우
            case 2:
                switch (arrow) {
                    case 0:
                    case 1:
                        check_place(i, j, 0);
                        check_place(i, j, 1);
                        break;
                    case 2:
                    case 3:
                        check_place(i, j, 2);
                        check_place(i, j, 3);
                        break;
                }
                break;

            // 상우, 우하, 하좌, 좌상
            case 3:
                switch (arrow) {
                    case 0:
                        check_place(i, j, 0);
                        check_place(i, j, 3);
                        break;
                    case 1:
                        check_place(i, j, 3);
                        check_place(i, j, 1);
                        break;
                    case 2:
                        check_place(i, j, 1);
                        check_place(i, j, 2);
                        break;
                    case 3:
                        check_place(i, j, 2);
                        check_place(i, j, 0);
                        break;
                }
                break;

            // 좌상우, 상우하, 우하좌, 하좌상
            case 4:
                switch (arrow) {
                    case 0:
                        check_place(i, j, 2);
                        check_place(i, j, 0);
                        check_place(i, j, 3);
                        break;
                    case 1:
                        check_place(i, j, 0);
                        check_place(i, j, 3);
                        check_place(i, j, 1);
                        break;
                    case 2:
                        check_place(i, j, 3);
                        check_place(i, j, 1);
                        check_place(i, j, 2);
                        break;
                    case 3:
                        check_place(i, j, 1);
                        check_place(i, j, 2);
                        check_place(i, j, 0);
                        break;
                }
                break;

            // 상하좌우
            case 5:
                check_place(i, j, 0);
                check_place(i, j, 1);
                check_place(i, j, 2);
                check_place(i, j, 3);
                break;

            default:
                break;
        }
    }

    // CCTV와 방향을 받아서 볼수 있는 곳은 체크!
    static void check_place(int i, int j, int arrow) {
        // 상, 하, 좌, 우

        while (true) {
            i += dx[arrow];
            j += dy[arrow];

            // 범위를 넘어섰을 때!
            if (i < 0 || i >= N || j < 0 || j >= M) break;
            // 벽일 때 break;
            if (arr[i][j] == 6) break;

            if (copyArr[i][j] == 0)
                copyArr[i][j] = -1;
        }
    }
}