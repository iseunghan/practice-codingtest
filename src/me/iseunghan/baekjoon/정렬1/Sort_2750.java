package me.iseunghan.baekjoon.정렬1;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Sort_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        Random random = new Random(1000000);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(bf.readLine());
            arr[i] = N--;
        }
        long start = System.currentTimeMillis();
        Arrays.sort(arr);

        for (int i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        long end = System.currentTimeMillis();
        double l = (end - start) / 1000.000;
        bw.write(l + "");
        bw.flush();
        bw.close();
    }
}
