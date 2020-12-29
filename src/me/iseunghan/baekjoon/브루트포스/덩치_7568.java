package me.iseunghan.baekjoon.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[] weights = new int[N];
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            weights[i] = x;
            heights[i] = y;
        }

        for (int i = 0; i < N; i++) {
            int rank = 0;
            int w1 = weights[i];
            int h1 = heights[i];
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    int w2 = weights[j];
                    int h2 = heights[j];
                    if (w1 < w2 && h1 < h2) {
                        rank++;
                    }
                }
            }
            bw.write(rank + 1 + " ");
        }

        bw.flush();
        bw.close();
    }
}