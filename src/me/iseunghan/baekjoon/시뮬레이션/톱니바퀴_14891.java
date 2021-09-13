package me.iseunghan.baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
    static int[][] arr;
    static boolean[] visit;
    static int[] arrows;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {-1, 1};
        arr = new int[5][9];
        arrows = new int[5];
        visit = new boolean[5];
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 1; i <= 4; i++) {
            String s = bf.readLine();
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == '0') arr[i][j] = 0;
                else arr[i][j] = 1;
            }
        }
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());

        for (int p = 0; p < n; p++) {
            st = new StringTokenizer(bf.readLine());

            int num = Integer.parseInt(st.nextToken());
            int arrow = Integer.parseInt(st.nextToken());

            visit = new boolean[5];

            visit[num] = true;
            arrows[num] = arrow;
            qu.offer(num);

            while (!qu.isEmpty()) {
                int x = qu.poll();

                // 왼쪽 오른쪽 탐색!
                for (int i = 0; i < 2; i++) {
                    int nX = x + dx[i];

                    // 범위를 벗어났을 때 PASS!
                    if (nX < 1 || nX > 4) continue;
                    if (visit[nX]) continue;

                    // 왼쪽, 오른쪽 톱니와의 비교!
                    if (i == 0) {
                        // left
                        if (arr[x][6] == arr[nX][2]) continue;
                    } else if (i == 1) {
                        if (arr[x][2] == arr[nX][6]) continue;
                    }
                    // 방문체크하고, 큐에 삽입
                    visit[nX] = true;
                    arrows[nX] = arrows[x] * -1;
                    qu.offer(nX);
                }

                // 처음에 큐에서 뽑은 톱니를 회전시킨다!
                // rotate(a[0] , arrow);
            }
            for (int i = 1; i <= 4; i++) {
                if (visit[i]) {
                    rotate(i, arrows[i]);
                }
            }
        }


        int answer = 0;
        // 톱니의 12시 방향이 S극일 때, 톱니별로 점수 추가
        for (int i = 1; i <= 4; i++) {
            if (arr[i][0] == 1) {
                switch (i) {
                    case 1:
                        answer += 1;
                        break;
                    case 2:
                        answer += 2;
                        break;
                    case 3:
                        answer += 4;
                        break;
                    case 4:
                        answer += 8;
                        break;
                }
            }
        }
        System.out.println(answer);
    }

    // 톱니를 회전시키는 메소드
    static void rotate(int num, int arrow) {
        int temp = 0;
        // 시계 방향일 때
        if (arrow == 1) {
            temp = arr[num][7];
            for (int i = 0; i < 7; i++) {
                arr[num][7 - i] = arr[num][6 - i];
            }
            arr[num][0] = temp;
        } else if (arrow == -1) {
            temp = arr[num][0];
            for (int i = 0; i < 7; i++) {
                arr[num][i] = arr[num][i + 1];
            }
            arr[num][7] = temp;
        }
    }
}