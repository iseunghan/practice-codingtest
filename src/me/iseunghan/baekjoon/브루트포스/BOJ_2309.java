package me.iseunghan.baekjoon.브루트포스;

import java.io.*;
import java.util.*;

public class BOJ_2309 {
    static int[] arr = new int[9];
    static int[] answer = new int[7];
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        recursion(0, 0);
    }

    public static void recursion(int depth, int start) {
        if (depth == 7) {
            if (Arrays.stream(answer).sum() == 100) {   // answer 배열의 합이 100인지 체
                Arrays.stream(answer).forEach(answer -> {
                    System.out.println(answer);
                });
                System.exit(0);     // 출력이 완료되었으면 시스템 종료
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recursion(depth + 1, start + 1);
                visited[i] = false;
            }
        }
    }
}
