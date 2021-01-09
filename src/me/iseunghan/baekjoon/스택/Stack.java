package me.iseunghan.baekjoon.스택;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 10828번 스택
 */
public class Stack {
    static java.util.Stack<Integer> st = new java.util.Stack<Integer>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        for (int i = 0; i < N; i++) {
            stack(bf.readLine());
        }
        bw.flush();
        bw.close();
    }

    private static void stack(String command) throws IOException {
        switch (command) {
            case "top":
                if (st.size() != 0) {
                    bw.write(st.peek() + "\n");
                } else {
                    bw.write("-1\n");
                }
                break;

            case "size":
                bw.write(st.size() + "\n");
                break;

            case "empty":
                if (st.size() != 0) {
                    bw.write("0\n");
                }else{
                    bw.write("1\n");
                }
                break;

            case "pop":
                if (st.size() != 0) {
                    bw.write(st.pop() + "\n");
                } else {
                    bw.write("-1\n");
                }
                break;

            default:
                st.push(Integer.parseInt(command.substring(5, command.length())));
                break;
        }

    }
}
