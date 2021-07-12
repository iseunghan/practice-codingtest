package me.iseunghan.baekjoon.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {
    static StringBuffer sb;
    static char[][] arr;
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 길이가 1일때 그냥 값 출력!
        if (N == 1) {
            System.out.print(bf.readLine());
            System.exit(0);
        }
        arr = new char[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        sb = new StringBuffer();

        // 재귀함수 시작!
        recur(N, 0, 0);

        String answer = sb.toString();

        // 압축하기!
        while (answer.contains("(0000)") || answer.contains("(1111)") || answer.contains("(0)") || answer.contains("(1)")) {
            answer = answer.replace("(0000)", "0");
            answer = answer.replace("0000", "0");
            answer = answer.replace("(1111)", "1");
            answer = answer.replace("1111", "1");
            answer = answer.replace("(0)", "0");
            answer = answer.replace("(1)", "1");
        }

        System.out.print(answer);
    }

    static void recur(int len, int x, int y) {
        // 만약 가장 작은 단위인 길이가 2일때 압축을 시도한다.
        if (len == 2) {
            sb.append("(");
            for (int i = 0; i < 4; i++) {
                if (arr[x + dx[i]][y + dy[i]] == '0') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            sb.append(")");
            return;
        }

        // 순서대로 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로 재귀 호출을 한다.
        sb.append("(");
        recur(len / 2, x, y);
        recur(len / 2, x, y + len / 2);
        recur(len / 2, x + len / 2, y);
        recur(len / 2, x + len / 2, y + len / 2);
        sb.append(")");
    }
}