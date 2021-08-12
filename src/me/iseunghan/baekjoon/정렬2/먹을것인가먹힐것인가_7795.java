package me.iseunghan.baekjoon.정렬2;

/**
 * https://www.acmicpc.net/problem/7795
 */

import java.util.*;
import java.io.*;

public class 먹을것인가먹힐것인가_7795 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            int result = 0;
            st = new StringTokenizer(bf.readLine());

            // 개수 입력
            int len_a = Integer.parseInt(st.nextToken());
            int len_b = Integer.parseInt(st.nextToken());

            // 배열 선언
            int[] A = new int[len_a];
            int[] B = new int[len_b];

            // 각 배열의 원소 입력 받기
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < len_a; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            // 각 배열의 원소 입력 받기
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < len_b; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            for (int j = 0; j < len_a; j++) {
                for (int k = 0; k < len_b; k++) {
                    if (A[j] > B[k]) {
                        result++;
                    } else {
                        break;
                    }
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}