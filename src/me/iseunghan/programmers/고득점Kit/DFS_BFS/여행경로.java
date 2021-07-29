package me.iseunghan.programmers.고득점Kit.DFS_BFS;

import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {
    static class Solution {
        static int N = 0, flag = 0; // 항공권의 개수, 종료 조건 flag
        static boolean[] visit;     // 방문 여부 체크
        static String[] answer;     // 정답 배열

        public String[] solution(String[][] tickets) {

            // 최대 깊이 설정
            N = tickets.length;

            // 정답 배열 크기 설정 & 방문 배열 크기 설정
            answer = new String[N+1];
            visit = new boolean[N];

            // Comparator를 이용하여 배열 정렬
            Arrays.sort(tickets, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if(o1[0].equals(o2[0])){
                        return o1[1].compareTo(o2[1]);
                    }
                    return o1[0].compareTo(o2[0]);
                }
            });

            // dfs 시작!
            for(int i=0; i<N; i++) {
                // 시작점 세팅 ICN 공항에서 출발하는 항공권 찾기.
                if(!visit[i] && tickets[i][0].equals("ICN")) {
                    visit[i] = true;
                    answer[0] = tickets[i][0];
                    dfs(1, i, tickets);
                    visit[i] = false;
                }

                if(flag == -1){
                    return answer;
                }
            }

            return answer;
        }

        public static void dfs (int depth, int prev, String[][] tickets) {
            if(depth == N) {
                // 마지막 도착지를 넣어준다.
                answer[N] = tickets[prev][1];
                // 종료 조건 입력
                flag = -1;
                return ;
            }

            for(int cur=0; cur<N; cur++){
                // 방문 여부 & 이전 도착지와 현재 출발지가 같은지 체크!
                if(!visit[cur] && tickets[prev][1].equals(tickets[cur][0])) {
                    visit[cur] = true;
                    answer[depth] = tickets[cur][0];
                    dfs(depth + 1, cur, tickets);
                    visit[cur] = false;
                }
                // 제일 처음으로 완성된 여행경로가 곧 알파벳 순서이므로 -> 종료 시킨다.
                if(flag == -1) {
                    return ;
                }
            }
        }
    }
}