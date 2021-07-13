package me.iseunghan.baekjoon.재귀;

import java.util.*;
import java.io.*;

public class 종이의개수_1780 {
    // 순서대로 0의 개수, 1의 개수, -1의 개수
    static int cnt_0 = 0, cnt_1 = 0, cnt_2 = 0;
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(N, 0, 0);

        System.out.print(cnt_2 + "\n" + cnt_0 + "\n" + cnt_1);
    }

    // 재귀 함수
    static void recur(int len, int x, int y) {
        // 동일한 수로 이루어졌다면 -> 리턴
        if (check(len, x, y)) {
            return;
        }

        // 9등분을 하여 다시 재귀호출을 한다.
        for (int i = x; i < x + len; i += len / 3) {
            for (int j = y; j < y + len; j += len / 3) {
                recur(len / 3, i, j);
            }
        }
    }

    /* 현재 정사각형이 동일한 수로 이루어졌는지 체크하는 함수
     *  return true(동일한 수로 이루어졌을 때)
     *  return false(동일한 수로 이루어져있지 않을 때)
     */
    static boolean check(int len, int x, int y) {
        int zero = 0, plus = 0, minus = 0;

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                switch (arr[i][j]) {
                    case 1:
                        plus++;
                        break;
                    case -1:
                        minus++;
                        break;
                    case 0:
                        zero++;
                        break;
                    default:
                        break;
                }
            }
        }
        if (zero == len * len) {
            cnt_0++;
            return true;
        } else if (plus == len * len) {
            cnt_1++;
            return true;
        } else if (minus == len * len) {
            cnt_2++;
            return true;
        }

        return false;
    }
}