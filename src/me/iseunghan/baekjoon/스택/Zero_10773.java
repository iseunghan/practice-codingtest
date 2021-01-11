package me.iseunghan.baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int N = Integer.parseInt(bf.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(bf.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        for (Integer integer : stack) {
            result += integer;
        }
        System.out.println(result);
    }
}
