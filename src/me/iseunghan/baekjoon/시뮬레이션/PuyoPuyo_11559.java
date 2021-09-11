package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class PuyoPuyo_11559 {
    static int flag = 0;
    static char color;
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> qu;
    static Queue<int[]> target_qu;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int play = 0;
        int target_cnt = 0;
        int boom_cnt = 0;
        map = new char[13][7];
        visit = new boolean[13][7];
        int[] dx = {-1, 1, 0, 0};   // 상,하,좌,우 (순서)
        int[] dy = {0, 0, -1, 1};
        qu = new LinkedList<>();
        target_qu = new LinkedList<>(); // for boom Queue

        for (int i = 0; i < 12; i++) {
            String str = bf.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] != '.')    play++;
            }
        }
        int boom_flag = 0;
        while(play > 0) {
            play--;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    // 방문 X, 빈칸 X 일 때!
                    if (!visit[i][j] && map[i][j] != '.') {
                        System.out.println("[target] : " + i + ", " + j + " : " + map[i][j]);
                        target_cnt = 0;
                        visit[i][j] = true; // 방문처리
                        color = map[i][j];  // color 지정
                        qu.offer(new int[]{i, j});
                        target_qu.offer(new int[]{i, j});
                    }

                    while (!qu.isEmpty()) {
                        int[] arr = qu.poll();
                        target_cnt++;   // 큐에서 뽑을 때마다 타겟 수 + 1
                        int x = arr[0];
                        int y = arr[1];


                        for (int p = 0; p < 4; p++) {
                            int nX = x + dx[p];
                            int nY = y + dy[p];

                            if (nX < 0 || nX > 11 || nY < 0 || nY > 5) continue;
                            if (visit[nX][nY]) continue;
                            if (color != map[nX][nY]) continue;

                            visit[nX][nY] = true; // 방문처리
                            qu.offer(new int[]{nX, nY});
                            target_qu.offer(new int[]{nX, nY});
                            System.out.println(map[nX][nY] + " 를 추가합니다. --");
                        }
                    }

                    // 타겟이 4개 이상인지?
                    if (target_cnt >= 4) {
                        // 연쇄 시작!
                        boom_flag = 1;
                        System.out.println("Boom 시킬 개수는  : " + target_cnt);
                        target_cnt = 0;
                        target_qu.clear();
                    } else {
                        while (!target_qu.isEmpty()) {
                            int[] a = target_qu.poll();
                            visit[a[0]][a[1]] = false;
                        }
                    }
                }
            }
            if(boom_flag == 1) {
                boom();
                boom_cnt++;
                boom_flag = 0;
            }
        }
        System.out.print(boom_cnt);
    }

    // true 인것들만 터치고 중력 적용!
    static void boom() {
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                if(visit[i][j]) {
                    System.out.println("[" + i + ", " + j +"] 를 제거합니다.");
                    visit[i][j] = false;

                    for (int p = i; p >= 1; p--) {
                        map[p][j] = map[p - 1][j];
                    }
                    // last
                    map[0][j] = '.';
                }
            }
        }
        /*while (!target_qu.isEmpty()) {
            int[] a = target_qu.poll();
            int x = a[0];
            int y = a[1];
            System.out.println(map[x][y] + " 를 제거합니다.");
            visit[x][y] = false;    // 방문 X 처리

            for (int i = x; i >= 1; i--) {
                map[i][y] = map[i - 1][y];
            }
            // last
            map[0][y] = '.';
        }*/
    }
}