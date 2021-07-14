package me.iseunghan.baekjoon.백트래킹;

import java.util.*;
import java.io.*;

public class 로또_6603 {
    static int K, cnt;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String read = bf.readLine();
        while (read.charAt(0) != '0') {
            st = new StringTokenizer(read);

            // K 크기 만큼 배열 초기화
            K = Integer.parseInt(st.nextToken());
            cnt = K;
            arr = new int[K];
            visit = new boolean[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            // 다음 입력 받기
            read = bf.readLine();
        }
    }

    // dfs로 구현
    static void dfs(int start, int depth) {
        // 6자리가 완료 되면 종료.
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                // 방문이 완료된 번호만 출력!
                if (visit[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // 시작위치부터 방문처리를 하면서 증가시킨다.
        for (int i = start; i < K; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);  // 다음 숫자 위치와 깊이를 1증가시킨 후 재귀호출!
            visit[i] = false;   // 재귀호출이 끝났으면 방문처리를 다시 취소해준다.
        }
    }
}
