package me.iseunghan.programmers.고득점Kit.해시;

import java.util.*;

/**
 * 해시 > 완주하지 못한 선수 > JAVA
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (completion[i].equals(participant[i])) {

            } else {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }
}