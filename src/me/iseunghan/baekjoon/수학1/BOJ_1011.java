package me.iseunghan.baekjoon.수학1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long X;
        long Y;
        long distance; // 행성 간 거리
        long max;
        long count = 0;

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            distance = Y - X; // 거리 계산
            max = (int) Math.sqrt(distance); // max 구하기

            if (max == Math.sqrt(distance)) {
                count = max * 2 - 1;
            } else {
                if (distance <= max * max + max) {
                    count = max * 2;
                } else {
                    count = max * 2 + 1;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
}