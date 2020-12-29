package me.iseunghan.baekjoon.수학1;

import java.io.*;
import java.util.StringTokenizer;

public class Snail_Wanna_Go_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        V -= A; // 첫날 값 미리 구해주기.
        int up = A - B; // 실제 올라가는 값
        int day = V / up;
        if (V % up != 0) {
            day++;
        }
        bw.write(day + 1 + "");

        // resource manage
        bw.flush();
        bw.close();
    }
}