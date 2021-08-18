package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;
import java.io.*;

public class 정수삼각형_1932 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[][] arr = new int[N + 1][N];
        int[][] sum = new int[N + 1][N];


        // input
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // init
        sum[1][0] = arr[1][0];

        if (N >= 2) {
            sum[2][0] = arr[1][0] + arr[2][0];
            sum[2][1] = arr[1][0] + arr[2][1];
        }

        // dp
        for (int i = 3; i <= N; i++) {
            for (int j = 0; j < i; j++) {

                if (j == 0) {
                    sum[i][0] = sum[i - 1][0] + arr[i][0];
                } else if (j == (i - 1)) {
                    sum[i][i - 1] = sum[i - 1][j - 1] + arr[i][j];
                } else {
                    sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + arr[i][j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (result < sum[N][i]) result = sum[N][i];
        }
        System.out.print(result);
    }
}