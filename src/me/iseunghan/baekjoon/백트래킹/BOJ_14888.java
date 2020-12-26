package me.iseunghan.baekjoon.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int MAX = Integer.MIN_VALUE; // 최대값
    static int MIN = Integer.MAX_VALUE; // 최소값
    static String[] operators;          // 연산자 배열
    static boolean[] isUsed;            // 연산자 사용 여부 체크
    static int[] numbers;               // 계산할 숫자 배열
    static int N;                       // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        numbers = new int[N];
        operators = new String[N-1];
        isUsed = new boolean[N];

        /* numbers 받기 */
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        /* operators 받기 */
        int index = 0;
        String oper = "+-*/";
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 0) {    // 시간 복잡도 조금이라도 줄이기..
                String op = oper.substring(i, i + 1);
                while (n-- > 0) {
                    operators[index++] = op;
                }
            }
        }

        dfs(1, numbers[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int depth, int sum) {

        /* 종료 조건 */
        if (depth == N) {
            if (MAX < sum)  MAX = sum;
            if (MIN > sum)  MIN = sum;
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            int cur = numbers[depth];
            if (!isUsed[i]) {
                isUsed[i] = true;
                int result = calc(sum, cur, operators[i]);
                dfs(depth + 1, result);
                isUsed[i] = false;
            }
        }
    }

    static int calc(int sum, int num, String oper) {
        switch (oper) {
            case "+":   sum += num;   break;
            case "-":   sum -= num;   break;
            case "*":   sum *= num;   break;
            case "/":   sum /= num;   break;
        }
        return sum;
    }
}
