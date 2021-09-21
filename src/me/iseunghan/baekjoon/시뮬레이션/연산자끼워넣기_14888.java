package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기_14888 {
    static int N;
    static int[] calc;        // 연산자를 저장한 배열
    static int[] select;      // 연산자 중 선택한 인덱스 저장 배열
    static int[] numbers;     // 계산할 숫자들 저장한 배열
    static boolean[] visit;   // 연산자를 사용했는지 체크하기 위한 배열
    static int MAX, MIN;      // 최댓값, 최솟값

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        MIN = Integer.MAX_VALUE;
        MAX = Integer.MIN_VALUE;
        N = Integer.parseInt(bf.readLine());

        calc = new int[N];
        select = new int[N];
        numbers = new int[N + 1];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(bf.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int c = Integer.parseInt(st.nextToken());
            while (c-- > 0) {
                calc[idx++] = i;
            }
        }
        dfs(0);
        // 최댓값, 최솟값 출력
        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int depth) {
        if (depth == N - 1) {
            int sum = numbers[0];
            // 0부터 N-1까지 고른 연산자를 계산하여 최댓값, 최솟값을 비교한다.
            for (int i = 0; i < N - 1; i++) {
                sum = operate(sum, numbers[i + 1], select[i]);    // (누적 합계, 계산할 숫자, 선택한 연산자)
            }

            if (sum > MAX) MAX = sum;
            if (sum < MIN) MIN = sum;

            return;
        }
        // 0~N-1 까지 연산자의 모든 경우를 다 탐색한다. select[depth]에 연산자를 넣어준다.
        for (int i = 0; i < N - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[depth] = calc[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    // 사칙연산에 따른 계산 결과 반환 ([0]:+ , [1]: - , [2]: * , [3]: /)
    static int operate(int sum, int n, int c) {
        switch (c) {
            case 0:
                return sum + n;
            case 1:
                return sum - n;
            case 2:
                return sum * n;
            case 3:
                return sum / n;
        }
        return sum;
    }
}