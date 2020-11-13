package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BlackJack_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Integer[] arr;

        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new Integer[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        int answer = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            answer = 0;
            for (int j = i + 1; j < arr.length; j++) {
                answer = arr[i] + arr[j];
                for (int k = j + 1; k < arr.length; k++) {
                    temp = answer + arr[k];
                    if (temp <= M && temp > max) {
                        max = temp;
                    }
                }
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
