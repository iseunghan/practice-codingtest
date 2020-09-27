package me.iseunghan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제 설명
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 * 입출력 예
 * prices	return
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 * 입출력 예 설명
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 */
public class Stock_Price {
    public int[] solution(int[] prices) {
        //prices : [1,2,3,2,3] , return : [4,3,1,1,0]
        int priceSize = prices.length;
        Queue<Integer> price_qu = new LinkedList<>();
        ArrayList<Integer> price_list = new ArrayList<>();

        //qu에 저장..
        for(int i=0; i<priceSize; i++){
            price_qu.add(prices[i]);
        }

        //while문 변수들
        int idx = 0;
        int up = 0;
        int time = 0;
        int flag = 0;
        //qu.isEmpty 일때 까지.
        while (!price_qu.isEmpty()) {
            //초기 실행
            if (flag == 0) {
                flag = 1;
                price_list.add(time);
            } else {
                int max = price_qu.poll();
                up++;
                for (int i = up; i < priceSize; i++) {
                    if (max > prices[i]) {
                        price_list.set(idx, ++time);
                        time = 0;
                        idx++;
                        price_list.add(time);
                        break;
                    } else {//max <= prices[i]
                        price_list.set(idx, ++time);
                        if (i == priceSize - 1) {
                            idx++;
                            time = 0;
                            price_list.add(time);
                        }
                    }
                }
            }
        }



        int listSize = price_list.size();
        int[] answer = new int[listSize];
        for(int i=0; i<listSize; i++){
            answer[i] = price_list.get(i);
        }


        return answer;
    }
}