package me.iseunghan.baekjoon.다이나믹프로그래밍;

import java.util.Scanner;

public class 피보나치수2_2748 {
        static long[] fib = new long[91];
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            long f = getFibonacci(n);
            System.out.println(f);

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