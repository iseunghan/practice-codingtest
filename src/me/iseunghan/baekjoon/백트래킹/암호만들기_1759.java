package me.iseunghan.baekjoon.백트래킹;

import java.util.*;
import java.io.*;

public class 암호만들기_1759 {
    static int L, C;
    static String[] arr, password;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        password = new String[L];   // 암호
        visit = new boolean[C];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    static void dfs(int depth, int idx) {
        if (idx == L) {
            int count = 0;  // 자음 카운트 변수

            for (int i = 0; i < L; i++) {
                if (password[i].equals("a") || password[i].equals("e") || password[i].equals("i") || password[i].equals("o") || password[i].equals("u"))
                    count++;
            }

            // 자음이 최소 1개이상, 모음이 최소 2개 이상인 조건을 만족하는가?
            if (count >= 1 && L - count >= 2) {
                for (int i = 0; i < L; i++)
                    System.out.print(password[i]);
                System.out.println();
            }
            return;
        }

        // idx가 L이상일 때, depth가 C일 때 종료
        if (idx > L || depth == C) {
            return;
        }

        password[idx] = arr[depth];
        dfs(depth + 1, idx + 1);  // 현재 단어(arr[detph]) 선택 O
        dfs(depth + 1, idx);      // 현재 단어(arr[detph]) 선택 X
    }
}