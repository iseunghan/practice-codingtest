package me.iseunghan.baekjoon.정렬2;

/**
 * https://www.acmicpc.net/problem/11652
 */

import java.util.*;
import java.io.*;

public class 카드_11652 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 카드 횟수의 최대값
        int MAX = 1;
        // 카드 값의 최소값
        Long result = Long.MAX_VALUE;
        int N = Integer.parseInt(bf.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long a = Long.valueOf(bf.readLine());

            // 만약 키값이 있다면? 기존의 횟수를 +1 증가!
            if (map.containsKey(a)) {
                int value = map.get(a);
                map.put(a, value + 1);

                // 최대 횟수를 기록.
                if (value + 1 > MAX)
                    MAX = value + 1;
            } else {
                // 기존 키값이 없다면 새로 삽입
                map.put(a, 1);
            }
        }

        // 순회하면서 최대 횟수이고, 제일 작은 키값을 찾아낸다.
        for (Long key : map.keySet()) {
            if (map.get(key) == MAX) {
                if (result > key) {
                    result = key;
                }
            }
        }

        System.out.print(result);
    }
}