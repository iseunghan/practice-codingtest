package me.iseunghan.baekjoon.큐;

import java.util.*;
import java.io.*;

public class 카드2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> qu = new LinkedList<>();

        if (N == 1) {
            System.out.print(1);
        } else {
            for (int i = 1; i <= N; i++) {
                qu.offer(i);
            }

            while (qu.size() != 2) {
                qu.poll();    // 무조건 첫 카드는 버린다.
                qu.offer(qu.poll());    // 뽑아서 맨 밑으로 넣는다.
            }

            qu.poll();
            System.out.print(qu.poll());
        }
    }
}
