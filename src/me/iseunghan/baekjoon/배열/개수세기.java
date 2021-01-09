package me.iseunghan.baekjoon.배열;

import java.io.*;
import java.util.StringTokenizer;

public class 개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[201];
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }
        System.out.println(arr[Integer.parseInt(bf.readLine()) + 100]);
    }
}
