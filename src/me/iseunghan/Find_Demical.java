package me.iseunghan;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * <p>
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * <p>
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
 * <p>
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 */
public class Find_Demical {
    public int run(String numbers) {
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
        int[] numArr = new int[maxNumber+1];
        for (int i = 0; i <= maxNumber; i++) {
            numArr[i] = i;
        }
        // 에라토스테네스의 체
        for (int i = 2; i <= maxNumber; i++) {
            if(numArr[i] == 0) continue;

            for (int j = i + i; j <= maxNumber; j += i) {
                numArr[j] = 0;
            }
        }
        // 소수를 담을 리스트 선언
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            if(numArr[i] == 0) continue;

            int cnt = 0;
            String[] tempArr = Arrays.copyOf(string_numbers, string_numbers.length);
            String s = numArr[i] + "";
            String[] split = s.split("");
            for(String s1 : split){
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