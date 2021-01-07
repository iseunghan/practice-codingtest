package me.iseunghan.baekjoon.재귀;

import java.util.Scanner;

/**
 * [재귀] 곱셈
 * https://www.acmicpc.net/problem/1629
 */
public class BOJ_1629 {
    static int A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        long l = 11;
        System.out.println(l / 2);
        System.out.println(pow(A % C, B, C));
    }

    private static int pow(int a, int b, int c) {
        if (b == 1)
            return a;

        int temp = pow(a, b / 2, c) % c;

        if (b % 2 == 0) {
            return (temp * temp) % c;
        } else {
            return ((temp * temp) % c * a) % c;
        }
    }


}
