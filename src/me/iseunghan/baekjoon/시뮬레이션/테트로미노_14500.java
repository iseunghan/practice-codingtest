package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 테트로미노_14500 {
    static int MAX = 0;
    static int N, M;
    static int R, C;
    static int[][] board;
    static int[][] temp;
    static int[][] copy;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[501][501];

        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 테트로미노의 5가지 도형을 리스트에 넣어줍니다.
        List<int[][]> list = new ArrayList<>();
        list.add(new int[][]{{1, 1, 1, 1}});
        list.add(new int[][]{{1, 1}, {1, 1}});
        list.add(new int[][]{{1, 0}, {1, 0}, {1, 1}});
        list.add(new int[][]{{1, 0}, {1, 1}, {0, 1}});
        list.add(new int[][]{{1, 1, 1}, {0, 1, 0}});

        // 5개의 테트로미노를 하나씩 다 끼워봅니다.
        for (int i = 0; i < 5; i++) {
            temp = list.get(i);
            R = temp.length;
            C = temp[0].length;

            // 오른쪽으로 90도씩 회전시켜서 총 4번을 회전시켜 끼워봅니다.
            for (int j = 0; j < 4; j++) {
                find_place();    // 끼울수 있는 곳 찾는 메소드

                rotate();        // 회전 시켜주는 메소드
            }
        }

        System.out.print(MAX);
    }

    // 테트로미노를 끼울 수 있는 지 확인
    static void find_place() {
        for (int i = 0; i <= N - R; i++) {
            for (int j = 0; j <= M - C; j++) {
                // 대칭까지 신경써야하기 때문에 reverse() 메소드까지
                for (int p = 0; p < 2; p++) {
                    paste(i, j);    // 1. 해당 부분을 끼워본다.
                    reverse();      // 2. 대칭시킨다.
                }
            }
        }
    }

    // 테트로미노를 붙여서 겹치는 칸의 값을 더합니다.
    static void paste(int x, int y) {
        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 겹치는 칸(1)만 합을 해줍니다.
                if (temp[i][j] == 1) {
                    sum += board[i + x][j + y];
                }
            }
        }

        if (MAX < sum) MAX = sum;
    }

    // 오른쪽으로 90도 회전시켜주는 메소드
    static void rotate() {
        // temp 배열을 복사하기 위한 copy
        copy = new int[R][C];

        // 복사
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copy[i][j] = temp[i][j];
            }
        }

        int tmp = R;
        R = C;
        C = tmp;

        temp = new int[R][C];

        // 회전시킨 temp 배열에 값을 넣어줍니다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = copy[C - 1 - j][i];
            }
        }
    }

    // 대칭시켜주는 메소드
    static void reverse() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C / 2; j++) {
                // 가운데를 기준으로 양쪽의 값을 바꿔줍니다. (대칭)
                int tmp = temp[i][j];
                temp[i][j] = temp[i][C - 1 - j];
                temp[i][C - 1 - j] = tmp;
            }
        }
    }
}