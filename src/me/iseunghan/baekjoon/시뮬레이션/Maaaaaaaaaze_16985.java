package me.iseunghan.baekjoon.시뮬레이션;

import java.io.*;
import java.util.*;

/**
 * 문제 접근 로직
 *      1. 첫번째부터 5번째 판의 회전율을 순열로 뽑는다.
 *      2. 그리구 회전을 시킨 다음, 해당 판을 놓을 수 있는 조합을 뽑아서 각 판의 순서를 바꾼다.
 *      3. 바꾼 판들을 가지고 bfs 탐색을 진행한다.
 *      4. 입구 -> 출구까지의 값을 비교하여 가장 작은 MIN 값을 출력한다.
 */
public class Maaaaaaaaaze_16985 {
    static int[] is_rotate;
    static int MIN;
    static int[] dx;
    static int[] dy;
    static int[] dz;
    static int[] pann;
    static boolean[] visit;
    static int[][][] cube;
    static int[][][] temp;

    public static void main(String args[]) throws IOException {
        StringTokenizer st;

        MIN = 1000;
        pann = new int[5];
        visit = new boolean[5];
        is_rotate = new int[5];
        temp = new int[5][5][5];
        cube = new int[5][5][5];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 위,아래,오,왼,앞,뒤
        dx = new int[]{-1, 1, 0, 0, 0, 0};
        dy = new int[]{0, 0, 0, 0, 1, -1};
        dz = new int[]{0, 0, 1, -1, 0, 0};

        // input
        for (int p = 0; p < 5; p++) {
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 5; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    // 문제에선 0이 벽이고 1이 빈칸이지만, 나는 1이 벽이고 0이 빈칸이라고 생각하고 코드를 작성했다. 주의!
                    if (v == 1)
                        cube[p][i][j] = 0;
                    else
                        cube[p][i][j] = -1;
                }
            }
        }

        // 미로 회전은 dfs로 회전시키기
        rotate_dfs(0);
        // 미로 탐색은 BFS를 사용.
        // temp 배열을 생성하여, BFS를 진행하면서 이전 값의 +1 씩 해주고, 제일 마지막에 탈출 꼭지점 값을 비교하여 MIN값 체크
        if (MIN + 1 == 1000) {
            MIN = -1;
        }
        System.out.print(MIN);
    }

    // 각 판의 회전율을 dfs로 찾는다.
    static void rotate_dfs(int depth) {
        if (depth == 5) {
            pann = new int[5];
            visit = new boolean[5];
            pann_dfs(0);

            return;
        }

        // 회전율을 순열로 뽑는다.
        for (int i = 0; i < 4; i++) {
            is_rotate[depth] = i;
            rotate_dfs(depth + 1);
        }
    }

    // 각판의 조합을 dfs로 뽑는다.
    static void pann_dfs(int depth) {

        if (depth == 5) {
            temp = new int[5][5][5];

            // 조합한 순서대로 판을 바꾼다.
            for (int p = 0; p < 5; p++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        temp[p][i][j] = cube[pann[p]][i][j];
                    }
                }
            }

            // 미리 뽑아둔 회전의 조합으로 회전을 시킨다
            for (int i = 0; i < 5; i++) {
                // System.out.print(is_rotate[i] + " ");
                rotate(i, is_rotate[i]);
            }

            // BFS로 탐색!
            int result = bfs() - 1;
            if (result < MIN) MIN = result;

            return;
        }

        // pann을 쌓는 방법을 조합한다.
        for (int i = 0; i < 5; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pann[depth] = i;
                pann_dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    // temp 배열을 d에 해당하는 판을 90 * z도 회전시킵니다.
    static void rotate(int d, int z) {
        if (z == 0) return;

        int[][] temp2 = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                temp2[i][j] = temp[d][i][j];
            }
        }

        // 회전 각에 따른 인덱스 계산법
        // 90도
        if (z == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[d][j][4 - i] = temp2[i][j];
                }
            }
        }
        // 180도
        else if (z == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[d][4 - i][4 - j] = temp2[i][j];
                }
            }
        }
        // 270도
        else if (z == 3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[d][4 - j][i] = temp2[i][j];
                }
            }
        }
    }

    // temp 배열을 BFS로 시작점과 끝점의 거리를 구합니다.
    static int bfs() {

        // 입구와 출구가 빈칸이 아니라면 PASS
        if (temp[0][0][0] != 0 || temp[4][4][4] != 0) {
            return 1000;
        }

        // temp2 배열에 복사
        int[][][] temp2 = new int[5][5][5];
        // temp 배열 복사
        for (int p = 0; p < 5; p++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp2[p][i][j] = temp[p][i][j];
                }
            }
        }

        Queue<int[]> qu = new LinkedList<>();

        // 방문체크 의미로 1을 넣어준다.
        temp2[0][0][0] = 1;
        qu.offer(new int[]{0, 0, 0});

        // BFS!
        while (!qu.isEmpty()) {
            int[] a = qu.poll();

            // 만약 탐색 중 출구를 찾았다면 바로 반환!
            if (a[0] == 4 && a[1] == 4 && a[2] == 4) {
                return temp2[4][4][4];
            }

            // 3차원이 움직일 수 있는 방향 6가지를 탐색한다.
            for (int i = 0; i < 6; i++) {
                int nX = a[0] + dx[i];
                int nY = a[1] + dy[i];
                int nZ = a[2] + dz[i];

                // 범위에 벗어나거나, 이미 방문했거나 벽인 경우에는 PASS!
                if (nX < 0 || nX >= 5 || nY < 0 || nY >= 5 || nZ < 0 || nZ >= 5) continue;
                if (temp2[nX][nY][nZ] != 0) continue;

                // 이전 경로의 값 + 1을 넣어준다.
                temp2[nX][nY][nZ] = temp2[a[0]][a[1]][a[2]] + 1;
                qu.offer(new int[]{nX, nY, nZ});
            }
        }

        if (temp2[4][4][4] < 1) {
            return 1000;
        }

        return temp2[4][4][4];
    }
}