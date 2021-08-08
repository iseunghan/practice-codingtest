package me.iseunghan.baekjoon.정렬2;

/**
 * https://www.acmicpc.net/problem/5648
 */

import java.util.*;
import java.io.*;

public class 역원소정렬_5648 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Long[] arr = {};
        int N = 1, idx = 0;

        // idx가 N과 같거나 크면 종료!
        while (idx < N) {
            st = new StringTokenizer(bf.readLine());

            // 초기 설정
            if (idx == 0) {
                N = Integer.parseInt(st.nextToken());
                arr = new Long[N];
            }

            // 토큰들이 더 있다면? reverse 메소드 호출
            while (st.hasMoreTokens()) {
                arr[idx++] = reverse(st.nextToken());
            }
        }

        // 배열에 담은 숫자들을 오름차순으로 정렬해준다.
        Arrays.sort(arr);

        for (Long i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }

    // 문자열을 뒤집어서 int형으로 변환시켜주는 메소드
    static Long reverse(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        Long result = Long.valueOf(sb.toString());

        return result;
    }
}