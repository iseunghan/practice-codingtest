package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 숨바꼭질_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int MAX = 100001;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] line = new int[MAX];    // 미리 배열을 100001 만큼 만들어 놓는다.
        Queue<Integer> qu = new LinkedList<>();

        if (N == K) {
            System.out.print(0);
            System.exit(0);
        }
        // 수빈이의 위치를 큐에 넣어준다.
        qu.offer(N);

        // BFS 시작!
        while (!qu.isEmpty()) {
            int a = qu.poll();    // 수빈이의 위치 꺼내기

            // 만약 K 보다 크거나, line[a+1] 값에 이미 방문한 상태라면 PASS
            if (a + 1 > K || line[a + 1] != 0) {

            } else {
                line[a + 1] = line[a] + 1;
                qu.offer(a + 1);
            }
            // 만약 0 보다 작거나, line[a-1] 값에 이미 방문한 상태라면 PASS
            if (a - 1 < 0 || line[a - 1] != 0) {

            } else {
                line[a - 1] = line[a] + 1;
                qu.offer(a - 1);
            }
            // 만약 K*2 보다 크거나, line[a*2] 값에 이미 방문한 상태라면 PASS
            if (a * 2 > MAX || (a * 2 > K * 2 || line[a * 2] != 0)) {

            } else {
                line[a * 2] = line[a] + 1;
                qu.offer(a * 2);
            }
        }
        // 동생 자리에 도착한 시간을 출력.
        System.out.print(line[K]);
    }
}