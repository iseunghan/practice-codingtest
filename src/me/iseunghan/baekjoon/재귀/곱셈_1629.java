package me.iseunghan.baekjoon.재귀;

import java.util.Scanner;

/**
 * [재귀] 곱셈
 * https://www.acmicpc.net/problem/1629
 */
public class 곱셈_1629 {
    static long A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(pow(A, B) % C);
    }

    private static long pow(long a, long b) {
        if (b == 1) {
            return a;
        }

        long temp = pow(a, b / 2) % C;

        if (b % 2 == 0) {
            return (temp * temp) % C;
        } else {
            return temp * temp % C * a % C;
        }
    }
}
