package me.iseunghan.baekjoon.재귀;

import java.util.Scanner;

public class Factorial_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = factorial(N);
        System.out.println(result);
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}