package me.iseunghan.baekjoon.백트래킹;

import java.io.*;
import java.util.*;

public class N_M_11 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    static StringBuffer sb = new StringBuffer();
    static LinkedHashSet<String> lhs = new LinkedHashSet<String>(); // 넣은 순서대로 저장!

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, "");

        for (String s : lhs) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int index, String str) throws IOException {
        if (index == M) {
            lhs.add(str.trim());
            return;
        }

        for (int i = 0; i < N; i++) {
                dfs(index + 1, str + " " + arr[i]);
        }
    }
}