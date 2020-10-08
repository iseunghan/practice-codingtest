package me.iseunghan.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumPick {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[set.size()];
        int idx = 0;
        for (Integer integer : set) {
            answer[idx++] = integer;
        }
        Arrays.sort(answer);

        return answer;
    }
}
