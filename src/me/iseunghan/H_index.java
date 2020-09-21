package me.iseunghan;

import java.util.*;

/**
 * 문제 설명
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 *
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 *
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 *      입출력              예
 *    citations	        return
 * [3, 0, 6, 1, 5]	       3
 * 입출력 예 설명
 * 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 *
 */
public class H_index {
    public int run(int[] citations){
        int answer = 0;

        /* 1번째 풀이
        // Collections.reverseOrder()를 사용하기 위해 Integer로 변
        Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        // 내림차순으로 정렬
        Arrays.sort(integers, Collections.reverseOrder());

        for (int i = 0; i < citations.length; i++) {
            // length와 비교하는 이유? h의 최대값은 (배열의 크기-1)이다! 왜냐하면 인용된 횟수의 최대가 6회인데 그러면 조건 "h번 인용된 논문이 h편 이상" 을 만족하지 않는다.
            // 게다가, 내림차순으로 정렬을 해서 "나머지 논문이 h번 이하 인용"은 자동으로 만족하게 된다.
            if (integers[i] <= i) {
                return i;
            }
        }
        */

        // 두번째 풀이
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= citations.length-i-1) {
                return citations.length - i-1;
            }
        }


        return citations.length;
    }
}
