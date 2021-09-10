package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    static int N, W, L, cur_w;
    static Queue<Integer> qu;
    static Queue<Integer> bridge;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int time = 0;
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        qu = new LinkedList<>();
        bridge = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            qu.offer(Integer.parseInt(st.nextToken()));
        }
        // 다리를 0(빈칸)으로 채운다.
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        // 다리가 비어있을 때 종료.
        while (!bridge.isEmpty()) {
            // 현재 다리에 있는 트럭이 빠져나오면서 무게를 제거한다.
            cur_w -= bridge.poll();
            // 시간 + 1
            time++;

            // 만약 현재 다리위의 트럭들의 무게가 다음 트럭을 올려도 버틸 수 있을 때!
            if (cur_w + qu.peek() <= L) {
                cur_w += qu.peek();    // 현재 무게 추가
                bridge.offer(qu.poll());// 다리에 트럭을 올린다.
                // 만약 모든 트럭이 다리위에 올라간 상태라면?
                if (qu.isEmpty()) {
                    // 현재 무게가 0이 될 때까지 시간을 증가시키면서 빼준다.
                    while (cur_w > 0) {
                        cur_w -= bridge.poll();
                        time++;
                    }
                }
            } else {
                // 트럭을 올리지 못할 경우 빈칸을 넣어준다.
                bridge.offer(0);
            }
        }
        System.out.print(time);
    }
}