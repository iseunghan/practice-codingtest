package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 스티커붙이기_18808 {
    static int N, M, K;
    static int R = 0, C = 0;
    static int[][] map;        // 노트북
    static int[][] temp;       // 임시 배열
    static int[][] sticker;    // 스티커 모눈종이
    static boolean flag;       // 종료조건 flag

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(bf.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 90도 씩 총 4번 회전시켜서 찾는다.
            for (int p = 0; p < 4; p++) {
                // 스티커를 붙였는지 체크!
                flag = false;
                // i, j 범위 주의!
                // 해당 스티커 모눈종이 전체를 끼워넣는다는 식으로 범위를 잡는다.
                for (int i = 0; i <= N - R; i++) {
                    for (int j = 0; j <= M - C; j++) {
                        // 현재 위치에 스티커를 붙일 수 있는지 체크!
                        flag = is_Paste(i, j);

                        if (flag) break;
                    }
                    if (flag) break;
                }
                if (flag) break;
                // 불가능하다면 회전
                rotate();
            }
        }

        int result = 0;
        // 스티커가 붙은 공간의 갯수를 센다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) result++;
            }
        }
        System.out.print(result);
    }

    // 스티커를 붙일 수 있는지 체크!
    static boolean is_Paste(int x, int y) {
        // 스티커 인덱스가 [i][j]라면, 노트북에 붙이는 공간의 인덱스는 [i+x][j+y] 이다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[x + i][y + j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }

        // 2중 for문을 따로 실행하는 이유는, 만약 위에서 같이 실행했다면 배열을 복사해서 스티커를 붙일 수 있다면
        // 붙이고, 만약 마지막 전까지 붙였는데 마지막 자리에 스티커를 붙일 수 없다면 이전의 작업을 되돌려야하므로 비효율적이다.
        // 먼저 붙일 수 있는지 확인을 싹 다 한뒤에 가능한 경우에만 스티커를 붙이는 것이 더 효율적이다. 매번 임시 배열도 안만들어도되고!
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1) {
                    map[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    // 90' 회전 시켜주는 rotate 메소드
    static void rotate() {

        temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = sticker[i][j];
            }
        }

        // 종이에 직접 그려보면, 오른쪽으로 90도 회전시켰을 때, 인덱스가 아래와 같이 되는 것을 알 수 있다.
        // [x][y] -> 90도 회전 -> [y][R-1-x]
        sticker = new int[C][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sticker[j][R - 1 - i] = temp[i][j];
            }
        }

        // 회전을 시켰으니, RxC를 CxR로 변경해준다.
        int tmp = R;
        R = C;
        C = tmp;
    }
}