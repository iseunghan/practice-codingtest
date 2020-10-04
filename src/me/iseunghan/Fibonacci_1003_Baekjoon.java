package me.iseunghan;

import java.util.Scanner;

public class Fibonacci_1003_Baekjoon {
    static long[] fib = new long[41];
    static int[] count_zero;
    static int[] count_one;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count_one = new int[n];
        count_zero = new int[n];
        int[][] counts = new int[n][2];
        for(int i=0; i<n; i++){
            count_zero[i]++;
            count_one[i]++;
            int x = sc.nextInt();
            fibonacci(x);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(counts[i][0] + " " + counts[i][1]);
        }
    }

    static long fibonacci(int n) {
        if (n == 0) {
            count_zero[0]++;
            return 0;
        } else if (n == 1) {
            count_one[1]++;
            return 1;
        }
        if (fib[n] != 0) {
            return fib[n];
        } else {
            return fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
