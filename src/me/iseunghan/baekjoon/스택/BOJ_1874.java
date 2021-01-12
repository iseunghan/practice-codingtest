package me.iseunghan.baekjoon.스택;

import java.io.*;
import java.util.Stack;

public class BOJ_1874 {
    static int idx = 0; // 수열의 인덱스
    static int[] arr;   // 수열을 저장할 배열
    static java.util.Stack<Integer> stack = new Stack<Integer>();   // 스택 구현
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N];

        // 수열 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i <= N; i++) {
            stack.push(i); /*bw.write("+\n");*/ // 현재 i를 push 후, "+" 출력
            sb.append("+\n");

            checkNumber();  // 현재 수열과 동일한 숫자인지 체크
        }

        // 스택이 비어있다면, 정상 출력
        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        }
        // 스택에 원소가 남아있다면, NO 출력
        else {
            System.out.println("NO");
        }

    }

    // 현재 수열과 스택의 top과 일치하는지 체크하는 메소드
    private static void checkNumber() throws IOException {
        while (!stack.isEmpty()) {

            if (stack.peek() == arr[idx]) {
                stack.pop();
                /*bw.write("-\n");*/
                sb.append("-\n");
                idx++;
            } else {
                break;
            }
        }
    }
}
