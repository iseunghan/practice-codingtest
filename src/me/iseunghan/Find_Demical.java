package me.iseunghan;

import java.util.ArrayList;

/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * 17	3
 * 011	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 */
public class Find_Demical {
    public int run(String numbers) {
        int answer = 0;
        String[] digit = numbers.split("");
        ArrayList<Integer> list = new ArrayList<>();

        //init
        for (int i = 0; i < digit.length; i++) {
            int i3 = Integer.parseInt(digit[i]);
            if(!list.contains(i3))  list.add(i3);
            for (int j = i+1; j < digit.length; j++) {
                int i1 = Integer.parseInt(digit[i] + digit[j]);
                int i2 = Integer.parseInt(digit[j] + digit[i]);
                if(!list.contains(i1)) list.add(i1);
                if(!list.contains(i2)) list.add(i2);
            }
        }

        for (Integer integer : list) {
            int sqrt = (int) Math.sqrt(integer);
            for (int i = 2; i <= sqrt; i++) {
                if (integer % i == 0) {
                    break;
                }else if(i == sqrt){
                    answer++;
                    break;
                }
            }
        }




        return answer;
    }
}
