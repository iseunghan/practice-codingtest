package me.iseunghan.programmers.고득점Kit.DFS_BFS;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {

    }

    public static class Solution {
        static int flag = 0;
        static int length = 0;
        static int answer = 0;
        static boolean[] visit;

        public static int solution(String begin, String target, String[] words) {
            length = words.length;
            visit = new boolean[length];    // 방문여부를 나타낼 배열

            // words 배열 정렬 시킨다.
            Arrays.sort(words);

            dfs(0, begin, target, words);
            return answer;
        }

        public static void dfs(int depth, String begin, String target, String[] words){
            if(begin.equals(target)){   // 정답이라면 answer변수에 변환 횟수를 넣어주고 flag -1 표시하여 종료.
                answer = depth;
                flag = -1;
                return ;
            }
            if(depth == length){    // 변환할 단어를 찾지 못했다면 종료.
                flag = -1;
                return ;
            }

            int index = 0;  // 변환할 단어의 자릿수
            for(int i=0; i<length; i++){
                if(!visit[i]){
                    int count = 0;

                    // (1) 변환할 단어를 찾는 반복문
                    for(int n = 0; n < begin.length(); n++){
                        if(begin.charAt(n) != words[i].charAt(n)){
                            index = n;  // 알파벳 바꿀 인덱스
                            count++;    // 다른 알파벳 개수
                        }
                    }

                    // (2) 변환할 단어를 찾았으면, 다시 다른 단어와 변환하기 위해 재귀호출!
                    if(count == 1){
                        visit[i] = true;    // 방문처리!
                        dfs(depth+1, words[i], target, words);
                        if(flag == -1){
                            break;  // -1 시그널이 들어오면 DFS 종료!
                        }
                    }
                }
            }
        }
    }
}
