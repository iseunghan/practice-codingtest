package me.iseunghan.baekjoon.정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[2000001];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(bf.readLine()) + 1000000] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sb.append(i - 1000000).append('\n');
            }
        }
        System.out.println(sb);
    }
}
