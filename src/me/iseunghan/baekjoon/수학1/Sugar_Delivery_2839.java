package me.iseunghan.baekjoon.수학1;

import java.io.*;

public class Sugar_Delivery_2839 {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        if (N == 4 || N == 7) {
            bw.write("-1");
        } else {
            while (N % 5 != 0) {
                N -= 3; answer += 1;

            }
            answer += N / 5;
            bw.write(answer + "");
        }

        bw.flush();
        bw.close();
    }
}