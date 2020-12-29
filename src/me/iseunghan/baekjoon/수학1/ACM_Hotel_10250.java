package me.iseunghan.baekjoon.수학1;

import java.io.*;
import java.util.StringTokenizer;

public class ACM_Hotel_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken()); //층
            int W = Integer.parseInt(st.nextToken()); //호수
            int N = Integer.parseInt(st.nextToken()); //몇번째

            int floor = 0; // 층수
            int hosu = N / H; // 호수
            if (N % H != 0) {
                floor = N % H;
                hosu++;
            } else {
                floor = H;
            }
            if (hosu < 10) {
                bw.write(floor + "0" + hosu + "\n");
            } else {
                bw.write(floor + "" + hosu + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}