package me.iseunghan.programmers.고득점Kit.DP;

import java.util.*;

public class N으로표현 {
    /*
     *   N을 i번 사용해서 나타낼 수 있는 수들을 map(i)의 List에 저장합니다.
     */
    static class Solution {
        static int target;

        public int solution(int N, int number) {

            target = number;

            // 같은 수 일 경우!
            if (N == number) {
                return 1;
            }

            int answer = -1;

            Map<Integer, HashSet<Integer>> map = new HashMap<>();

            for (int i = 1; i <= 8; i++) {
                map.put(i, new HashSet<Integer>());
            }

            // init
            HashSet<Integer> set = map.get(1);
            set.add(N);

            // 중간 답을 찾았을 때 종료하기 위한 변수 flag
            int flag = -1;

            // 2부터 시작
            for (int i = 2; i <= 8; i++) {
                flag = -1;
                // System.out.println("------" + i + "--------");
                for (int j = i - 1; j >= (int) Math.round(i / 2); j--) {
                    flag = calc(map.get(j), map.get(i - j), map.get(i), i, N);

                    // 정답을 찾았을 때 리턴!
                    if (flag == 1) {
                        return i;
                    }
                }
            }

            // 전체 리스트를 순회하면서 N을 몇번 사용했는지 찾습니다.
            for (int i = 1; i <= 8; i++) {
                HashSet<Integer> set2 = map.get(i);
                Iterator iter = set2.iterator();
                while (iter.hasNext()) {
                    int a = (int) iter.next();
                    if (number == a) {
                        return i;
                    }
                }
            }

            return answer;
        }

        static int calc(HashSet<Integer> prev, HashSet<Integer> prev2, HashSet<Integer> cur, int d, int N) {
            int plus = 0, min = 0, mult = 0, div = 0;
            for (int i : prev) {
                for (int j : prev2) {
                    // 덧셈
                    plus = i + j;
                    cur.add(plus);
                    // 곱셈
                    mult = i * j;
                    cur.add(mult);

                    // 뺄셈, 나눗셈
                    if (i > j) {
                        min = i - j;
                        div = i / j;
                    } else {
                        min = j - i;
                        div = j / i;
                    }

                    // 0 또는 음수 체크
                    if (min > 0)
                        cur.add(min);
                    if (div > 0)
                        cur.add(div);

                    // 정답인지 체크!
                    if (plus == target || min == target || mult == target || div == target) {
                        return 1;
                    }
                }
            }

            // 자릿수에 해당하는 NN..N 추가
            int last = N;
            for (int i = 0; i < d - 1; i++) {
                last = last * 10 + N;
            }

            cur.add(last);

            // NN..N 도 정답인지 체크
            if (last == target) {
                return 1;
            }

            return -1;
        }
    }
}