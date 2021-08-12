package me.iseunghan.baekjoon.정렬2;

import java.util.*;
import java.io.*;

public class 국영수_10825 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        String[][] grades = new String[N][4];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            grades[i][0] = st.nextToken();   // 이름
            grades[i][1] = st.nextToken();   // 국어
            grades[i][2] = st.nextToken();   // 영어
            grades[i][3] = st.nextToken();   // 수학
        }

        // 문자열 비교 equals 사용! int형 변환후 비교!
        Arrays.sort(grades, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                // 국어 점수가 다를 때 비교
                if (!s1[1].equals(s2[1])) {
                    return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
                }
                // 국어 점수가 같고, 영어 점수가 다를 때 비교
                else if (!s1[2].equals(s2[2])) {
                    return Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
                }
                // 국어,영어 점수가 같고, 수학 점수가 다를 때 비교
                else if (!s1[3].equals(s2[3])) {
                    return Integer.parseInt(s2[3]) - Integer.parseInt(s1[3]);
                }
                // 모든 점수가 같고, 이름으로 비교
                else {
                    return s1[0].compareTo(s2[0]);
                }
            }
        });

        for (String[] s : grades) {
            bw.write(s[0] + "\n");
        }

        bw.flush();
        bw.close();
    }
}