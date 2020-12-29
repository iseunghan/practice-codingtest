package me.iseunghan.baekjoon.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018 {
    static int MIN = 2501;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H][W];
        // init
        String s = "";
        for (int i = 0; i < H; i++) {
            s = bf.readLine();
            String[] split = s.split("");
            for (int j = 0; j < W; j++) {
                if (split[j].equals("W")) {
                    // White : +1
                    arr[i][j] = 1;
                } else {
                    // Black : -1
                    arr[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < H - 8 + 1; i++) {
            for (int j = 0; j < W - 8 + 1; j++) {
                paint(arr, i, j);
            }
        }

        bw.write(MIN + "");
        bw.flush();
        bw.close();
    }

    private static void paint(int[][] arr, int i, int j) {
        int count = 0;
        int flag = 1;

        for (int p = i; p < i + 8; p++) {
            for (int q = j; q < j + 8; q++) {
                if (!(arr[p][q] == flag)) {
                    count++;
                }
                flag *= -1;
            }
            flag *= -1;
        }

        int temp = Math.min(count, 64 - count);
        MIN = Math.min(MIN, temp);

    }

}
