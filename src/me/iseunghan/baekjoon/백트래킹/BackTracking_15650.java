package me.iseunghan.baekjoon.백트래킹;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BackTracking_15650 {
    static BufferedWriter bw;
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] diff;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        diff = new int[M];
        visited = new boolean[N + 1];

        recursion(0);
        bw.flush();
        bw.close();
    }

    private static void recursion(int index) throws IOException {

        if (index == M) {
            int result = 0;
            diff = Arrays.copyOf(arr, arr.length);
            Arrays.sort(diff);
            for (int i = 0; i < M; i++) {
                result += diff[i] * Math.pow(10, M - 1 - i);
            }
            if (!list.contains(result)) {
                list.add(result);
                for (int i = 0; i < M; i++) {
                    bw.write(arr[i] + " ");
                }
                bw.write("\n");
            }
//            visited[arr[index - 1]] = false;
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[index] = i;
                visited[i] = true;
                recursion(index + 1);
                visited[i] = false;
            }
        }
    }
}
