package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 소문난칠공주_1941 {
    static int answer;
    static char[] arr;
    static int[] dx;
    static int[] temp;
    static int[] pairs;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        dx = new int[]{1, -1, 5, -5};
        arr = new char[26];
        temp = new int[26];
        pairs = new int[8];

        // input
        for (int i = 1; i < 26; ) {
            String s = bf.readLine();
            arr[i++] = s.charAt(0);
            arr[i++] = s.charAt(1);
            arr[i++] = s.charAt(2);
            arr[i++] = s.charAt(3);
            arr[i++] = s.charAt(4);
        }

        // dfs
        for (int i = 1; i < 26; i++) {
            pairs[1] = i;
            if (arr[i] == 'S') dfs(2, i, 1);
            else dfs(2, i, 0);
        }

        System.out.print(answer);
    }

    static void dfs(int depth, int start, int count) {
        if (depth == 8) {
            // S가 4명이상일때만!
            if (count >= 4) {
                // 해당 조합이 연결된 자리인지 판별!
                if (isLinked()) answer++;
            }
            return;
        }

        // 이전 원소는 탐색하지 않는다. (i = start + 1부터 시작하기 때문에)
        for (int i = start + 1; i < 26; i++) {
            pairs[depth] = i;
            // S라면 count+1
            if (arr[i] == 'S') dfs(depth + 1, i, count + 1);
            else dfs(depth + 1, i, count);
        }
    }

    // 서로 연결되어 있는지 체크하는 메소드
    static boolean isLinked() {
        int cnt = 0;
        temp = new int[26]; // 1: 방문 필요, -1: 방문 완료, 0: 방문 불필요

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= 7; i++) {
            temp[pairs[i]] = 1;
        }
        // 방문 완료 처리 후, 큐 삽입
        temp[pairs[1]] = -1;
        qu.offer(pairs[1]);

        while (!qu.isEmpty()) {
            int x = qu.poll();
            int range = get_Range(x);   // 왼쪽, 오른쪽 탐색 할 경우) 해당 인덱스가 range ~ range+5 까지의 범위를 갖는다.
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];

                // 범위 벗어나면 PASS
                if (i == 0 || i == 1)   // 1. 왼쪽, 오른쪽 탐색할 때의 범위 주의!
                    if (nX < range || nX >= range + 5) continue;
                if (i == 2 || i == 3)   // 2. 위, 아래 탐색은 1과 25 범위 안에만 들면 됨!
                    if (nX < 1 || nX > 25) continue;
                // 방문 했거나, 필요없으면 PASS
                if (temp[nX] == 0 || temp[nX] == -1) continue;

                temp[nX] = -1;  // 방문 완료 처리
                qu.offer(nX);   // 큐 삽입
            }
        }
        // cnt가 7이라면 연결된 자리이므로 true
        if (cnt == 7) return true;
        return false;
    }

    // 1 ~ 5 , 6 ~ 10 , 11 ~ 15 , 16 ~ 20 , 21 ~ 25 각각의 범위를 리턴한다.
    static int get_Range(int x) {
        if (x <= 5) {
            return 1;
        } else if (x <= 10) {
            return 6;
        } else if (x <= 15) {
            return 11;
        } else if (x <= 20) {
            return 16;
        } else {
            return 21;
        }
    }
}