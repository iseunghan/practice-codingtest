package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 치킨배달_15686 {
    static int N, M, house_cnt, chick_cnt;
    static int MIN = 10000;
    static int[] choose;
    static int[][] house;
    static int[][] chicken;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 선택한 치킨집의 인덱스를 담고 있는 배열 선언
        choose = new int[M + 1];
        // 최대 2*N개의 집이므로, 101 사이즈로 줌.
        // [101] : 1부터 시작하여 집에 번호를 매긴다.
        //  [17] : 1~14번의 치킨집까지의 거리 측정. [16]:치킨집의 x좌표, [17]:치킨집의 y좌표
        house = new int[101][17];
        // i번째 치킨집의 좌표를 저장 [i][0]: x좌표, [i][1]: y좌표
        chicken = new int[15][2];

        house_cnt = 1;    // 일반 집 개수
        chick_cnt = 1;    // chicken 집 개수

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    house[house_cnt][15] = i;
                    house[house_cnt++][16] = j;
                } else if (input == 2) {
                    chicken[chick_cnt][0] = i;
                    chicken[chick_cnt++][1] = j;
                }
            }
        }
        // 각 집에서의 모든 치킨집과의 거리 계산
        for (int i = 1; i < house_cnt; i++) {
            for (int j = 1; j < chick_cnt; j++) {
                house[i][j] = Math.abs(house[i][15] - chicken[j][0]) + Math.abs(house[i][16] - chicken[j][1]);
            }
        }

        // 백트래킹, 1번째 치킨집을 고르고, 1번째 부터 탐색!
        dfs(1, 1);

        System.out.print(MIN);
    }

    static void dfs(int depth, int start) {
        // 종료 조건 : M개의 치킨집을 골랐을 경우
        if (depth == M + 1) {
            int sum = 0;

            for (int i = 1; i < house_cnt; i++) {
                int dist = 10000;
                for (int j = 1; j <= M; j++) {
                    // 해당 집의 치킨 거리를 구한다.
                    dist = Math.min(dist, house[i][choose[j]]);
                }
                sum += dist;
            }

            if (MIN > sum) MIN = sum;

            return;
        }

        // depth번 이후 치킨집 선택
        // i번째를 선택했다면 다음번에는 i+1번째를 선택!
        for (int i = start; i < chick_cnt; i++) {
            choose[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}