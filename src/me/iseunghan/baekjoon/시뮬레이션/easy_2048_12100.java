package me.iseunghan.baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class easy_2048_12100 {
    static int N, MAX;
    static int[] dx;
    static int[] dy;
    static int[] arrows;    // 5가지의 방향 저장하기 위한 배열
    static int[][] arr;     // 원본 보드 배열
    static int[][] temp;    // 복사 배열

    public static void main(String args[]) throws IOException {
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        MAX = 0;
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        arrows = new int[5];
        dx = new int[]{0, -1, 0, 1};
        dy = new int[]{-1, 0, 1, 0};

        // 보드 블럭 값 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.print(MAX);
    }

    // 블럭을 움직일 방향 : 좌(0), 상(1), 우(2), 하(3)

    // dfs 시작!
    static void dfs(int depth) {
        // 5가지 방향을 정했다면 진입!
        if (depth == 5) {
            // 원본 보드 arr 배열 복사
            temp = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            // 지금까지의 방향을 토대로 2048 게임 시작!
            for (int i = 0; i < 5; i++) {
                play(arrows[i]);
            }

            // 완료된 temp 배열에서 최대값 찾기!
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (MAX < temp[i][j]) {
                        MAX = temp[i][j];
                    }
                }
            }
            return;
        }

        // 모든 방향 다 둘러보기
        for (int i = 0; i < 4; i++) {
            arrows[depth] = i;
            dfs(depth + 1);
        }
    }

    // 방향에 맞게 블럭을 옮긴다.
    static void play(int arrow) {

        switch (arrow) {
            // 0: 왼쪽
            // 1'행'씩 살펴볼 것이다.
            // 왼쪽으로 옮길 때는, 왼쪽 -> 오른쪽 순으로 원소를 살피면서 합칠 것이다.
            case 0:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        move_To_Board(i, j, 2);
                    }
                }
                break;
            // 1: 위쪽
            // 1'열'씩 살펴볼 것이다.
            // 위쪽으로 옮길 때는, 위쪽 -> 아래쪽 순으로 원소를 살피면서 합칠 것이다.
            case 1:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        move_To_Board(j, i, 3);
                    }
                }
                break;
            // 2: 오른쪽
            // 1행씩 살펴볼 것이다.
            // 오른쪽으로 옮길 때는, 오른쪽 -> 왼쪽 순으로 원소를 살피면서 합칠 것이다.
            case 2:
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j >= 0; j--) {
                        move_To_Board(i, j, 0);
                    }
                }
                break;
            // 3: 아래쪽
            // 1열씩 살펴볼 것이다.
            // 아래쪽으로 옮길 때는, 아래쪽 -> 위쪽 순으로 원소를 살피면서 합칠 것이다.
            case 3:
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = N - 1; j >= 0; j--) {
                        move_To_Board(i, j, 1);
                    }
                }
                break;
        }
    }

    // arrow(방향)으로 보드를 옮기는 메소드
    static void move_To_Board(int i, int j, int arrow) {
        int nX = i, nY = j;
        // 해당 원소가 0이 아닐 때
        if (temp[i][j] != 0) {
            while (true) {

                nX += dx[arrow];
                nY += dy[arrow];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) return;
                if(temp[nX][nY] == 0)   continue;

                // 1. 해당 수와 같은 수를 찾는다.
                if (temp[i][j] == temp[nX][nY]) {
                    temp[i][j] *= 2;
                    temp[nX][nY] = 0;

                    return ;
                } else if (temp[nX][nY] != 0) {
                    // 다른 수를 만났을 경우 종료!
                    return;
                }
            }
        } else {
            // 0일 때
            int flag = 0;

            while (true) {

                nX += dx[arrow];
                nY += dy[arrow];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) return;
                if (temp[nX][nY] == 0)  continue;

                // 1. 해당 수와 같은 수를 찾는다.
                if (flag == 0) {
                    temp[i][j] = temp[nX][nY];
                    temp[nX][nY] = 0;

                    // 최초 1회만 가능
                    flag = -1;
                }
                // 같은 수를 발견했을 때, 더하고 끝!
                else if (temp[nX][nY] == temp[i][j]) {
                    temp[i][j] *= 2;
                    temp[nX][nY] = 0;
                    break;
                } else {
                    break;
                }
            }
        }
    }
}