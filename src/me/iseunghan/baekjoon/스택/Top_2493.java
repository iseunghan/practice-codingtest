package me.iseunghan.baekjoon.스택;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= a) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[]{i, a});
        }
    }
}
