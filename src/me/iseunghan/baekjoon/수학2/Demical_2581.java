package me.iseunghan.baekjoon.수학2;

import java.io.*;

public class Demical_2581 {
    static int[] demical;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        demical = new int[N + 1];
        demical[0] = -1;
        demical[1] = -1;
        for (int i = 2; i < demical.length; i++) {
            if (demical[i] == 0) {
                for (int j = i * i; j < demical.length; j += i) {
                    demical[j] = -1;
                }
            }
        }

        int answer = 0;
        int min = 0;
        for (int i = M; i <= N; i++) {
            if (demical[i] != -1) {
                if (answer == 0) {
                    min = i;
                }
                answer += i;
            }
        }
        if (answer == 0) {
            bw.write("-1");
        } else {
            bw.write(answer + "\n");
            bw.write(min + "");
        }

        bw.flush();
        bw.close();
    }
}
