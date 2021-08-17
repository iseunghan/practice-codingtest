package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.*;

public class Nx2타일링_11726 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fibo = new int[N + 2];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= N + 1; i++) {
            fibo[i] = fibo[i - 1] % 10007 + fibo[i - 2] % 10007;
        }

        System.out.print(fibo[N + 1] % 10007);
    }
}