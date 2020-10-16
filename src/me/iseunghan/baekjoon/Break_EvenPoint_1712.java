package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Break_EvenPoint_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = 0;
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long C = Long.parseLong(st.nextToken());

        if (C > B) {
            N = (int) (A / (C - B)) + 1;
        }else{
            N = -1;
        }

        System.out.println(N);
    }
}
