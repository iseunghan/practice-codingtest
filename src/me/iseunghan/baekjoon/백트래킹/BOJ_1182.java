package me.iseunghan.baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    static int N, S, result;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) System.out.print(result - 1);
        else System.out.print(result);
    }

    public static void dfs(int depth, int num) {
        /*  depth가 N일 때만 체크 */
        if (depth == N) {
            if (num == S) {
                result++;
            }
            return;
        }
        /**
         * ex) 3개의 수열 {1,2,3}
         * 모든 부분수열 : {(공집합)}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}
         * S = 0 일때는 공집합의 개수를 빼줘야 한다!
         */
            dfs(depth + 1, num);                    // 현재 인덱스(depth)를 더하지 않을 경우
            dfs(depth + 1, num + arr[depth]);  // 현재 인덱스(depth)를 더하는 경우

    }
}