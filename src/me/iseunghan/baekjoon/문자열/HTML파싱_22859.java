package me.iseunghan.baekjoon.문자열;

import java.util.Scanner;
import java.util.Stack;

public class HTML파싱_22859 {
    static int[] endPoints = new int[1_000_001];
    static String str;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        str = sc.nextLine();

        // 스택에 <의 해당하는 닫힌 괄호 >의 인덱스를 endPoints에 저장합니다.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') stack.add(i);
            if (str.charAt(i) == '>') endPoints[stack.pop()] = i;
        }
        parsing_HTML(0, str.length());
    }

    // 1. HTML을 파싱합니다.
    static void parsing_HTML(int s, int e) {
        // 2. '<div '로 시작하면 parsing_Div로 , '<p>' 태그는 parsing_P 메소드를 실행시킵니다.
        for (int i = s; i < e; i++) {
            if (str.charAt(i) == '<') {
                if (str.charAt(i + 1) == 'd') {
                    // <div가 아닐 수 있으므로, 예외처리..
                    try {
                        String div = str.substring(i, i + 5);
                        if (div.equals("<div ")) parsing_Div(str.substring(i, endPoints[i]));
                    } catch (Exception exception) {
                    }
                } else if (str.charAt(i + 1) == 'p') {
                    if (str.charAt(i + 2) == '>') parsing_P(i + 1);
                }
            }
        }
    }

    static void parsing_Div(String s) {
        // s는 <div title="(A)" 형태로 들어옵니다.
        // substring으로 (A) 부분만 잘라내서 title에 넣어줍니다.
        String title = s.substring(12, s.length() - 1);
        System.out.println("title : " + title);
    }

    static void parsing_P(int s) {
        // <p>ABC***</p> 에서 p부분에 해당하는 인덱스가 s로 들어옵니다.
        int end = 0;
        // </p> 까지 index를 증가시키면서 end변수에 '<'부분의 인덱스를 넣어줍니다.
        for (int i = s; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                if (str.charAt(i + 1) == 'p') {
                    if (str.charAt(i + 2) == '>') {
                        end = i - 1;
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 매개변수로 받았던 s+2부터 시작하면서 안에 있는 태그들은 continue시키면서 문자열을 합칩니다.
        for (int i = s + 2; i < end; i++) {
            if (str.charAt(i) == '<') {
                i = endPoints[i];
                continue;
            }
            sb.append(str.charAt(i));
        }
        // 2개 이상의 공백을 1개의 공백으로 대체하고, 시작과 끝 공백을 제거시키고 출력시킵니다.
        String result = sb.toString().replaceAll("\\s+", " ");
        System.out.println(result.trim());
    }
}