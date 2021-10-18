package me.iseunghan.baekjoon.문자열;

import java.util.*;

public class 압축_1662 {
    static int[] endPoints = new int[51];
    static String str;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.add(i); // ( 의 위치
            if (str.charAt(i) == ')') endPoints[stack.pop()] = i;   // '(' 의 ')' 위치를 저장시킨다.
        }

        System.out.println(extract(0, str.length()));
    }

    static int extract(int start, int end) {
        int len = 0;

        for (int i = start; i < end; i++) {
            if (str.charAt(i) == '(') {
                /*
                 *   재귀호출할 때, 왜 endPoints[i]-1이 아닌가하면, for문의 i<end이기 때문이다. 어차피 endPoints[i]-1까지만 탐색함.
                 *   또, 왜 마지막에 -1을 해주냐면, K를 센 횟수 1을 빼주는 것임.
                 */
                len += (str.charAt(i - 1) - '0') * extract(i + 1, endPoints[i]) - 1;
                i = endPoints[i];   // 이것도 왜 endPoints[i]+1이 아닌가하면, for문의 i++ 조건때문에 어차피 +1이 되버림.
            } else {
                len++;
            }
        }
        return len;
    }
}