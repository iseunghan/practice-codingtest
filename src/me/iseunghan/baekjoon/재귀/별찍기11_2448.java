package me.iseunghan.baekjoon.재귀;


import java.util.*;
import java.io.*;

public class 별찍기11_2448 {
    static int N;
    static String[][] arr;
    static BufferedWriter bw;

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = sc.nextInt();
        arr = new String[N][6 * (N / 3) - 1];
        recur(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null) {
                    bw.write(" ");
                } else
                    bw.write(arr[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void recur(int len, int x, int y) throws IOException {
        if (len == 3) {
            arr[x][y + 2] = "*";
            arr[x + 1][y + 1] = "*";
            arr[x + 1][y + 3] = "*";
            for (int i = 0; i < 5; i++) {
                arr[x + 2][y + i] = "*";
            }
            return;
        }

        // len 6이상일 때 -> 분할하기!
        recur(len / 2, x, y + len / 2);
        recur(len / 2, x + len / 2, y);
        recur(len / 2, x + len / 2, y + len / 2);
    }
}
