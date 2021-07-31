package me.iseunghan.programmers.고득점Kit.완전탐색;

import java.util.*;

public class 소수찾기 {
    public int solution(String numbers) {
        int answer = 0;
        // "1234" -> 1, 2, 3, 4
        String[] string_numbers = numbers.split("");
        // 4, 3, 2, 1
        Arrays.sort(string_numbers);
        String strToInt = "";
        // 1,2,3,4를 내림차순으로 strToInt에 더해준다.
        for (int i = string_numbers.length - 1; i >= 0; i--) {
            strToInt += string_numbers[i];
        }
        // strToInt = "4321"
        int maxNumber = Integer.parseInt(strToInt); // 4321
        //int[] 0부터 4321 까지 넣기
        int[] numArr = new int[maxNumber + 1];
        for (int i = 0; i <= maxNumber; i++) {
            numArr[i] = i;
        }
        // 에라토스테네스의 체
        for (int i = 2; i <= maxNumber; i++) {
            if (numArr[i] == 0) continue;

            for (int j = i + i; j <= maxNumber; j += i) {
                numArr[j] = 0;
            }
        }
        // 소수를 담을 리스트 선언
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            if (numArr[i] == 0) continue;

            int cnt = 0;
            String[] tempArr = Arrays.copyOf(string_numbers, string_numbers.length);
            String s = numArr[i] + "";
            String[] split = s.split("");
            for (String s1 : split) {
                for (int k = 0; k < tempArr.length; k++) {
                    if (s1.equals(tempArr[k])) {
                        tempArr[k] = "-1";
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == s.length()) {
                answer++;
            }
        }
        return answer;
    }
}
