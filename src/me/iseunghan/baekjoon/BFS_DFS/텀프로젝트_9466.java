package me.iseunghan.baekjoon.BFS_DFS;

import java.util.*;
import java.io.*;

public class 텀프로젝트_9466 {
    static int[] arr;
    static boolean[] visit, done;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        StringTokenizer st;

        // 테스트 케이스 개수만큼 반복!
        for (int p = 0; p < T; p++) {
            int n = Integer.parseInt(bf.readLine());
            arr = new int[n + 1];
            visit = new boolean[n + 1]; // 방문 여부
            done = new boolean[n + 1];  // 팀 결성 완료 여부
            count = 0;  // 정답

            st = new StringTokenizer(bf.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!done[i]) { // 팀 결성이 안됐을 경우에만 dfs 시작!
                    dfs(i);
                }
            }
            // count는 팀원이 된 학생들의 수이므로, 정답은 (전체 학생 - count) 이다.
            bw.write((n - count) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int n) {
        // 이미 방문 했을 때!
        if (visit[n]) {
            done[n] = true; // 팀 결성했다고 체크
            count++;        // 팀원 결성된 학생 수 증가!
        } else {
            visit[n] = true;// 방문 안했을 때, 방문 처리!
        }

        // 다음 학생이 팀 결성을 아직 못했을 경우
        if (!done[arr[n]]) {
            dfs(arr[n]);    // 다음 학생을 dfs 시작!
        }
        // dfs가 끝나고 난 뒤, 방문 여부를 되돌려주고, 팀 결성이 됐다고 해준다.(어차피 정답은 "모든 학생 수" - "팀원 결성된 학생 수")
        visit[n] = false;
        done[n] = true;
    }
}