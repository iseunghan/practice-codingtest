package me.iseunghan.programmers.level_1;

public class 피보나치수 {
    static class Solution {
        static int[] arr = new int[100_001];

        public int solution(int n) {
            // init
            arr[0] = 0;
            arr[1] = 1;

            return fibonacci(n) % 1234567;
        }

        public static int fibonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (arr[n] == 0) {
                arr[n] = fibonacci(n - 1) % 1234567 + fibonacci(n - 2) % 1234567;
            }
            return arr[n] % 1234567;
        }
    }
}
