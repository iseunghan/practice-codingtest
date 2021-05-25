package me.iseunghan.baekjoon.연결리스트;

import java.util.*;
import java.io.*;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        bw.write("<");

        int temp = 0;
        int count = 0;
        while (queue.size() != 1) {
            temp = queue.poll();
            count++;
            if (count == K) {
                count = 0;
                bw.write(temp + ", ");
            } else {
                queue.offer(temp);
            }
        }
        bw.write(queue.poll() + ">");
        bw.flush();
        bw.close();
    }
}