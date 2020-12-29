package me.iseunghan.baekjoon.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class SangSu_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int MAX = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 2; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 3자리수를 자리 바꿈
            int d = num % 10;
            int dd = (num / 10) % 10;
            int ddd = num / 100;
            int newNum = d * 100 + dd * 10 + ddd;
            if (MAX < newNum) {
                MAX = newNum;
            }
        }
        bw.write(MAX + "");
        bw.flush();
        bw.close();

    }
}
