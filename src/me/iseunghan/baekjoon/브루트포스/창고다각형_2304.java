package me.iseunghan.baekjoon.브루트포스;

import java.io.*;
import java.util.*;

public class 창고다각형_2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int[] top = new int[1002];
        int[] L_MAX = new int[1002];
        int[] R_MAX = new int[1002];
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        // input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            top[k] = v;
        }

        // 왼쪽->오른쪽 최댓값 pick
        // 오른쪽->왼쪽 최댓값 pick
        for (int i = 1; i <= 1000; i++) {
            L_MAX[i] = Math.max(L_MAX[i - 1], top[i]);
            R_MAX[1001 - i] = Math.max(R_MAX[1001 - i + 1], top[1001 - i]);
        }

        // 그 둘 중 최솟값을 택하면 됩니다.
        for (int i = 1; i <= 1000; i++) {
            answer += Math.min(L_MAX[i], R_MAX[i]);
        }

        System.out.println(answer);
    }
}