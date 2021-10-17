package me.iseunghan.baekjoon.시뮬레이션;

// 뿌요뿌요의 다른 풀이
import java.util.*;
import java.io.*;

public class PuyoPuyo_2_11559 {
    static int[] dx;
    static int[] dy;
    static char[][] puyo;
    static boolean[][] visit;
    static boolean[][] target;

    public static void main(String args[]) throws IOException {
        // init
        int play = 0;
        int answer = 0;
        puyo = new char[13][7];
        visit = new boolean[13][7];
        target = new boolean[13][7];
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // input
        for (int i = 0; i < 12; i++) {
            String s = bf.readLine();

            for (int j = 0; j < 6; j++) {
                puyo[i][j] = s.charAt(j);
                // .이 아닌경우에만 play 증가
                if (puyo[i][j] != '.') play++;
            }
        }

        Queue<int[]> qu = new LinkedList<>();

        int boom_flag = 0;
        // play 수만큼 반복적으로 수행!
        while (play-- >= 0) {

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {

                    if (puyo[i][j] != '.') {
                        int boom_cnt = 0;
                        visit = new boolean[13][7];

                        visit[i][j] = true;
                        qu.offer(new int[]{i, j});

                        // BFS
                        while (!qu.isEmpty()) {
                            int[] a = qu.poll();
                            boom_cnt++;    // qu에서 뽑으면서 카운트 증가

                            for (int p = 0; p < 4; p++) {
                                int nX = a[0] + dx[p];
                                int nY = a[1] + dy[p];

                                if (nX < 0 || nX >= 12 || nY < 0 || nY >= 12) continue;
                                if (visit[nX][nY]) continue;
                                if (puyo[nX][nY] != puyo[a[0]][a[1]]) continue;

                                visit[nX][nY] = true;    // 이전 뿌요 중복 방문 방지
                                qu.offer(new int[]{nX, nY});
                            }
                        }
                        // 카운트가 4개 이상일 경우에
                        if (boom_cnt >= 4) {
                            boom_cnt = 0;
                            // 터뜨려야할 뿌요 그룹들이 여러곳에 있어도 최종 터뜨린 횟수는 무조건 1회이다.
                            // 그렇기 때문에 한번에 터뜨리기위해 target에 모아둔다.
                            for (int n = 0; n < 12; n++) {
                                for (int m = 0; m < 6; m++) {
                                    if (visit[n][m])
                                        target[n][m] = visit[n][m];
                                }
                            }
                            // 터뜨리기 위한 flag
                            boom_flag = 1;
                        }
                    }
                }
            }
            // flag가 1이라면 모아뒀던 뿌요들을 터뜨린다. 터뜨린 횟수 + 1
            if (boom_flag == 1) {
                boom_flag = 0;
                boom_puyo();
                target = new boolean[13][7];    // target 초기화
                answer++;
            }
        }
        System.out.println(answer);
    }

    // 모아둔 뿌요들을 터뜨리고 중력을 적용시킨다.
    static void boom_puyo() {
        // 터뜨릴 뿌요들을 마킹
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (target[i][j]) puyo[i][j] = '-';
            }
        }

        // 중력 적용
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 12; i++) {

                if (puyo[i][j] == '-') {

                    for (int p = i; p >= 1; p--) {
                        puyo[p][j] = puyo[p - 1][j];
                    }
                    puyo[0][j] = '.';
                }
            }
        }
    }
}