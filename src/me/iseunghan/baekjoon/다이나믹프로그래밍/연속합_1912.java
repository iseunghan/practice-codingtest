package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        // init
        int sum = 0;
        int MAX = -1001;
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // dp 시작
        // 1. 입력을 받음과 동시에 변수 a에 저장.
        // 2. sum 변수에 더하고, MAX 값과 비교
        // 3. 만약 sum이 음수라면 0으로 초기화
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());

            sum += a;

            if (MAX < sum) MAX = sum;
            if (sum < 0) sum = 0;
        }

        System.out.print(MAX);
    }
}