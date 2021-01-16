package me.iseunghan.baekjoon.큐;

import java.io.*;

public class BOJ_10845 {
    static int index = 0;
    static int size = 0;
    static int front = 0;
    static int back = 0;
    static Queue<Integer> qu;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Queue<T> {
        private int[] queue;
        private int seq = 0;

        public Queue(int size) {
            this.queue = new int[size + 1];
        }

        private void push(int n) {
            queue[seq++] = n;
            size++;

            if (size == 1) {
                front = n;
                back = n;
            } else {
                back = n;
            }
        }

        private int pop() {
            if (size > 0) {
                size--;
                front = queue[++index];
                return queue[index - 1];
            }
            return -1;
        }

        private int size() {
            return size;
        }

        private int empty() {
            if (size > 0) {
                return 0;
            }
            return 1;
        }

        private int front() {
            if (size > 0) {
                return front;
            }
            return -1;
        }

        private int back() {
            if (size > 0) {
                return back;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(bf.readLine());
        qu = new Queue<Integer>(N);

        for (int i = 0; i < N; i++) {
            command(bf.readLine());
        }
        bw.flush();
        bw.close();
    }

    private static void command(String s) throws IOException {
        switch (s) {
            case "pop":
                bw.write(qu.pop() + "\n");
                break;
            case "size":
                bw.write(qu.size() + "\n");
                break;
            case "empty":
                bw.write(qu.empty() + "\n");
                break;
            case "front":
                bw.write(qu.front() + "\n");
                break;
            case "back":
                bw.write(qu.back() + "\n");
                break;
            default:
                qu.push(Integer.parseInt(s.substring(5)));
                break;
        }
    }
}
