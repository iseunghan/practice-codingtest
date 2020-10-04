package me.iseunghan;

import java.util.Scanner;

public class Fibonacci_2748_Baekjoon {
    static long[] fib = new long[91];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long f = getFibonacci(n);
        System.out.println("f = " + f);

    }

    public static long getFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        return fib[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}

