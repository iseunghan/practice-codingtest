package me.iseunghan.baekjoon;

import java.io.*;

public class WillBe_Chairman_2775 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        int a = 0;
        int b = 0;

        for (int i = 0; i < T; i++) {
            a = Integer.parseInt(bf.readLine());
            b = Integer.parseInt(bf.readLine());
            dp = new int[a + 1][b + 1];
            bw.write(dp(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int dp(int a, int b) {
        if (b == 1) {
            return 1;
        }
        if (a == 0) {
            return b;
        }
        return dp[a][b] = dp(a, b - 1) + dp(a - 1, b);
    }

}
