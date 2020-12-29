package me.iseunghan.baekjoon.수학2;

import java.io.*;
import java.util.StringTokenizer;

public class Find_Demical_1978 {
    static int[] demical = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 2; i < demical.length; i++) {
            if (demical[i] == 0) {
                for (int j = i * i; j < demical.length; j += i) {
                    demical[j] = -1;
                }
            }
        }

        int N = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a >= 2 && demical[a] != -1) {
                answer++;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
