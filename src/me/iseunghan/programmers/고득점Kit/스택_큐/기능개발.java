package me.iseunghan.programmers.고득점Kit.스택_큐;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int prev = 0;

        Queue<Integer> qu = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = 100 - progresses[i];
            int diff = (day % speeds[i] == 0) ? day / speeds[i] : day / speeds[i] + 1;
            qu.offer(diff);
        }

        int cnt = 1;
        int idx = 0;

        while (!qu.isEmpty()) {
            int present = qu.poll();

            if (prev == 0) { //최초 실행시 실행
                prev = present;
                list.add(cnt);
            } else { //그 이후 실행..
                if (prev >= present) { //prev가 클때
                    list.set(idx, ++cnt); //** 중요 코드 : cnt증가후 값 변경.
                } else { //prev가 작을때
                    prev = present;
                    idx++; //인덱스 증가.
                    cnt = 1; //cnt 1로 초기화.
                    list.add(cnt); //list에 초기화 시킨 cnt를 넣어둔다.
                }
            }
        }


        //list -> 배열로 변환시키기.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}
