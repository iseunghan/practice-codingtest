package me.iseunghan.baekjoon;

import java.io.*;

public class Word_Study_1157 {
    static int[] arr = new int[26]; // 미리 배열 생성
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine().toUpperCase(); // 대문자로 변경
        int MAX = 0;
        char result = '?';
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 65; //문자열의 아스키 코드
            arr[idx]++;
            if (MAX < arr[idx]) {
                MAX = arr[idx];
                result = s.charAt(i);
            } else if (MAX == arr[idx]) {
                result = '?';
            }

        }
        bw.write(result);
        bw.flush(); // 자원관리 해주기! 꼭
        bw.close();
    }
}
