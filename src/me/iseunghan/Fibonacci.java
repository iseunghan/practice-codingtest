package me.iseunghan;

/**
 * 피보나치 수열 이란? 1 1 2 3 5 8 13 21 34 55 ....
 * fib[n] = fib[n-1] + fib[n-2] (단, fib[1],fib[2] = 1)
 * recursion(재귀)을 사용하여 피보나치 수열을 간단하게 해결 할 수 있다.
 */
public class Fibonacci {
    int[] fibs = new int[51];
    public void run() {
        int fib = fib(1);
        System.out.println("fib = " + fib);
    }

    public int fib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        if (fibs[x] != 0) {
            return fibs[x];
        }
        return fibs[x] = fib(x - 1) + fib(x - 2);
    }
}
