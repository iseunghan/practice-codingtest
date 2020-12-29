package me.iseunghan.baekjoon.수학2;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Demical_1929 {
    static int[] demical;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        demical = new int[N + 1];
        demical[0] = -1;
        demical[1] = -1;
        for (long i = 2; i < demical.length; i++) {
            if (i <= 1000 && demical[(int) i] == 0) {
                for (long j = i * i; j < demical.length; j += i) {
                    demical[(int) j] = -1;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (demical[i] == 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}