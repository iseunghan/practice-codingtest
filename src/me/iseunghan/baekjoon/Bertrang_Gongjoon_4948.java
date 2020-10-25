package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Bertrang_Gongjoon_4948 {
    static int[] demical = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        demical[0] = -1;
        demical[1] = -1;
        int max = (int) Math.sqrt(246912);
        for (long i = 2; i < demical.length; i++) {
            if (i <= max && demical[(int) i] == 0) {
                for (long j = i * i; j < demical.length; j += i) {
                    demical[(int) j] = -1;
                }
            }
        }

        while (true) {
            int count = 0;
            int N = Integer.parseInt(bf.readLine());
            if (N == 0) {
                break;
            }
            for (int i = N+1; i <= 2 * N; i++) {
                if (demical[i] == 0) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
}