package me.iseunghan.programmers.level_3;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 * 프로그래머스 > 2021 Dev-Matching 웹 백엔드 개발자(상반기) > 다단계 칫솔 판매
 */

import java.util.*;

public class 다단계칫솔판매 {

    class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            long start = System.currentTimeMillis();
            int[] answer = new int[enroll.length];

            Map<String, Info> map = new HashMap<>();
            Queue<Info> qu = new LinkedList<>();

            for (int i = 0; i < enroll.length; i++) {
                map.put(enroll[i], new Info(referral[i], i));
            }

            // 1. seller를 순회하면서 이익금 계산 시작!
            for (int i = 0; i < seller.length; i++) {
                // 이익금 * 100
                int benefit = amount[i] * 100;

                // 2. 판매한 사람의 Info클래스를 큐에 넣어줍니다.
                qu.offer(map.get(seller[i]));

                while (!qu.isEmpty()) {
                    Info info = qu.poll();

                    // 수익률 / 10이 1원 미만일 경우!
                    if (benefit / 10 < 1) {
                        info.updateAmount(benefit);
                        break;
                    }

                    // 10% 뺀 나머지금액 갖기
                    info.updateAmount(benefit - (benefit / 10));

                    // 추천인이 center가 아닐 경우에만 큐에 넣어준다.
                    if (!info.getReferName().equals("-")) {
                        qu.offer(map.get(info.getReferName()));
                    }
                    // 이익금 10%로 분할!
                    benefit /= 10;
                }
            }

            // 정답 배열에 넣어주기.
            for (String k : map.keySet()) {
                Info info = map.get(k);
                answer[info.getNum()] = info.getAmount();
            }

            return answer;
        }

        // 추천인과 이익금을 필드로 가지는 클래스
        class Info {
            String referName;
            int num;
            int amount;

            public Info(String referName, int num) {
                this.referName = referName;
                this.num = num;
            }

            public String getReferName() {
                return referName;
            }

            public int getNum() {
                return num;
            }

            public int getAmount() {
                return amount;
            }

            public void updateAmount(int n) {
                this.amount += n;
            }
        }
    }
}