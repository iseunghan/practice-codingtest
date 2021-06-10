package me.iseunghan.baekjoon.스택;

import java.util.*;
import java.io.*;

public class BOJ_9012 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 첫 줄에 정수 N을 입력 받는다.
        int N = Integer.parseInt(bf.readLine());
        // 괄호를 처리하기 위해 스택 생성
        Stack<String> stack = new Stack<>();

        // 괄호 문자열 만큼 반복
        for (int i = 0; i < N; i++) {
            int flag = 0;   // 불완전한 괄호일 경우 종료시키기 위한 flag 변수
            String[] arr = bf.readLine().split(""); // 괄호마다 배열에 저장
            // 문자열 길이만큼 반복
            for (int j = 0; j < arr.length; j++) {
                switch (arr[j]) {
                    case "(":   // ( 일때는 그냥 push!
                        stack.push("(");
                        break;
                    case ")":   // ) 일때는 ( 가 있는지 확인 후, 없으면 flag 에 -1값 처리!
                        if (stack.size() > 0 && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            flag = -1;
                        }
                        break;
                    default:
                        flag = -1;
                        break;
                }

                if (flag == -1) // 비정상적인 괄호가 있다는 표시, 반복문을 바로 종료 시킴.
                    break;
            }
            // 스택이 비워져있어야 하고, flag 도 0이여야 정답처리이다.
            if (stack.size() == 0 && flag == 0) {
                bw.write("YES\n");
            } else {    // 그렇지 않다면 NO 출력
                bw.write("NO\n");
            }
            stack.clear();  // 한 라인을 처리했으면, 스택을 비워줍니다.
        }
        bw.flush(); // 정답 출력.
        bw.close();
    }
}