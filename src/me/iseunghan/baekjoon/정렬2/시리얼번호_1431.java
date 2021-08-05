package me.iseunghan.baekjoon.정렬2;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/1431
 * 정렬2 > 1431 시리얼 번호 > JAVA
 */
public class 시리얼번호_1431 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = bf.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                // 1. 길이가 작은 순
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    // 2. 숫자 더한 값이 작은 순
                    int r1 = 0, r2 = 0;

                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) <= 57)
                            r1 += s1.charAt(i) - 48;
                        if (s2.charAt(i) <= 57)
                            r2 += s2.charAt(i) - 48;
                    }

                    if (r1 != r2) {
                        return r1 - r2;
                    } else {
                        // 3. 사전순으로 나열
                        return s1.compareTo(s2);
                    }
                }
            }
        });

        // 맨 앞에서 부터 출력
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}