package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

public class 뱀_3190 {
    static int N, K, L;
    static int hX, hY, arrow;
    static int[][] map;
    static int[] arrows;
    static int[] dx;
    static int[] dy;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 0 위, 1 오, 2 아, 3 왼
        arrow = 1;
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};

        /* map, arrows 최대 크기로 초기화 */
        N = Integer.parseInt(bf.readLine());
        map = new int[101][101];
        arrows = new int[10001];

        /* 사과(2) 위치 저장 */
        K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 2;  // 사과(2) 표시
        }

        /* 어느 시간이 끝난 뒤에 방향을 전환해야하는지 저장 */
        L = Integer.parseInt(bf.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            if (s.equals("L"))
                arrows[x] = -1; // 왼쪽
            else
                arrows[x] = 1;  // 오른쪽
        }

        // init
        Queue<int[]> qu = new LinkedList<>(); // 지렁이의 몸통 정보를 담을 큐

        int time = 0;   // 시간 세팅
        hX = 1;         // 머리의 x 좌표
        hY = 1;         // 머리의 y 좌표
        map[1][1] = 1;  // 지렁이 몸통 표시
        qu.offer(new int[]{1, 1});

        // map :  0은 빈칸, 1은 지렁이의 몸통, 2는 사과
        while (true) {
            time++;

            // 방향에 따른 머리 위치 이동
            int nhX = hX + dx[arrow];
            int nhY = hY + dy[arrow];

            // 벽에 부딪혔다면 종료
            if (nhX < 1 || nhX > N || nhY < 1 || nhY > N) break;
            // 자기자신의 몸통과 부딪혔다면 종료
            if (map[nhX][nhY] == 1) break;

            // 머리 위치를 기억한다.
            hX = nhX;
            hY = nhY;

            // 1. 다음칸으로 이동한 머리 x,y좌표를 저장한다.
            qu.offer(new int[]{nhX, nhY});

            // 2. 이동한 칸에 사과가 있는지 체크!
            if (map[nhX][nhY] != 2) {
                // 사과가 없다면 꼬리가 위치한 칸을 비운다.
                int[] tail = qu.poll();
                map[tail[0]][tail[1]] = 0;
            }
            // 사과가 있던 없던 머리는 옮긴다. (map에 표시해준다.)
            map[nhX][nhY] = 1;

            // X초가 끝난 뒤에 arrows[X]의 값이 있다면 방향을 바꿔준다.
            if (arrows[time] != 0) {
                turn_arrow(arrows[time]);
            }
        }

        System.out.print(time);
    }

    // 현재 방향을 기준으로 왼쪽, 오른쪽으로 변경해주는 메소드
    static void turn_arrow(int dir) {
        // 만약 현재 0(위) 방향일 때, 왼쪽이면 3이 되어야 한다.
        // 아래의 식을 따르면, 4 + 0 -1 = 3이고 4로 나눈 나머지는 3이 된다.
        arrow = (4 + arrow + dir) % 4;
    }
}