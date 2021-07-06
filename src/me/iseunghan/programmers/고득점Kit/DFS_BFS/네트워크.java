package me.iseunghan.programmers.고득점Kit.DFS_BFS;

import java.util.*;

public class 네트워크 {

    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[][] visit = new boolean[n][n];  // 방문여부
            Queue<int[]> qu = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int count = 0;  // 연결된 네트워크 수 체크하기 위한 변수
                for (int j = 0; j < n; j++) {
                    if (i == j || visit[i][j]) {
                        continue;
                    }

                    if (computers[i][j] == 1) {
                        visit[i][j] = true; // 양쪽 다
                        visit[j][i] = true; // 방문 체크!
                        qu.offer(new int[]{i, j});  // 큐에 삽입
                        answer++;
                    } else {
                        count++;    // 방문도 안했고, 연결이 되지 않았다면 count를 증가!
                    }

                    while (!qu.isEmpty()) {
                        int[] arr = qu.poll();

                        // 연결된 컴퓨터에 또 연결된 컴퓨터가 있는지 확인하는 BFS!
                        for (int p = 0; p < n; p++) {
                            // 인덱스가 자기 자신과 같거나, 방문을 했다면 PASS!
                            if (arr[1] == p || visit[arr[1]][p]) {
                                continue;
                            }
                            // 연결된 컴퓨터가 없다면 PASS
                            if (computers[arr[1]][p] != 1) {
                                continue;
                            }

                            visit[arr[1]][p] = true;    // 양쪽 다
                            visit[p][arr[1]] = true;    // 방문 체크
                            qu.offer(new int[]{arr[1], p}); // 다시 큐에 넣어준다.
                        }
                    }
                }
                // 아무 컴퓨터와 연결이 안되어있을 경우!
                if (count == n - 1) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
