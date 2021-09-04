package me.iseunghan.baekjoon.정렬1;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);

        for (int i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}