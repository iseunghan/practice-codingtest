package me.iseunghan.baekjoon.수학2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Triangle_4153 {
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s = bf.readLine();

        while (!s.equals("0 0 0")) {
            st = new StringTokenizer(s);
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if ((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
                bw.write("right" + "\n");
            } else {
                bw.write("wrong" + "\n");
            }
            s = bf.readLine();
        }
        bw.flush();
        bw.close();
    }
}
