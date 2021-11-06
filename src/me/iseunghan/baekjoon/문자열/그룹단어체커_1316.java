package me.iseunghan.baekjoon.문자열;

import java.io.*;

public class 그룹단어체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            answer += getWordCount(bf.readLine());
        }
        System.out.println(answer);
    }

    public static int getWordCount(String s) {
        int flag = 1;

        for (int i = 0; i < s.length(); i++) {
            flag = 1;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (flag == 0) {
                        return 0;
                    }
                } else {
                    flag = 0;
                }
            }
        }
        return 1;
    }
}
