package me.iseunghan.baekjoon;

import java.util.Scanner;

public class Fibonacci_10870 {
    //10870번 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = fibonacci(N);
        System.out.println(result);
    }

    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

