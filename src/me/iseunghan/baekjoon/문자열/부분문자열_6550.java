package me.iseunghan.baekjoon.문자열;

import java.util.*;
import java.io.*;

public class 부분문자열_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input = "";

        while ((input = bf.readLine()) != null) {
            st = new StringTokenizer(input);

            String S = st.nextToken();
            String T = st.nextToken();

            int MAX = get_MaxLength(T, S);    // 일치하는 문자의 최대 길이

            // 일치하는 문자열 최대 길이가 S의 길이와 동일하면 Yes
            if (MAX == S.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    // KMP 알고리즘을 활용
    private static int get_MaxLength(String parent, String pattern) {
        int MAX = 0;
        int[] table = new int[parent.length()];

        int j = 0;
        for (int i = 0; i < parent.length(); i++) {
            if (pattern.charAt(j) == parent.charAt(i)) {
                table[i] = ++j;
                if (MAX < table[i]) MAX = table[i];
            }
            // j가 찾고자하는 문자열의 길이와 동일하다면 종료
            if (j == pattern.length()) break;
        }
        return MAX;
    }
}