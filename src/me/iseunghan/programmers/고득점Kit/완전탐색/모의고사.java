package me.iseunghan.programmers.고득점Kit.완전탐색;

import java.util.ArrayList;
import java.lang.Math;

public class 모의고사 {

    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            int[] p1 = {1, 2, 3, 4, 5};
            int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int ap1 = 0, ap2 = 0, ap3 = 0;

            for (int i = 0; i < answers.length; i++) {
                if (p1[i % p1.length] == answers[i]) ap1++;
                if (p2[i % p2.length] == answers[i]) ap2++;
                if (p3[i % p3.length] == answers[i]) ap3++;
            }

            int max = Math.max(Math.max(ap1, ap2), ap3);

            ArrayList<Integer> list = new ArrayList<Integer>();
            if (ap1 == max) list.add(1);
            if (ap2 == max) list.add(2);
            if (ap3 == max) list.add(3);

            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
