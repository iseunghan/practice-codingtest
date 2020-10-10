package me.iseunghan.programmers;

public class Coding_Test3 {
    public int solution(int n, int[][] groups) {
        int answer = 0;
        int[] lamps = new int[n]; //lamps 배열 생성 0: OFF, 1: ON

        for (int[] group : groups) {
            for (int i = group[0]; i <= group[1]; i++) {
                lamps[i] = 1;
            }
        }

        //마지막 단일 작업 카운팅
        for (int lamp : lamps) {
            if(lamp == 0)
                answer++;
        }

        return answer;
    }
}
