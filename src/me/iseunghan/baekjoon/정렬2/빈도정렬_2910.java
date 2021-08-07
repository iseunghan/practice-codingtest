package me.iseunghan.baekjoon.정렬2;

import java.util.*;
import java.io.*;

public class 빈도정렬_2910 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int MAX_COUNT = 1;

        st = new StringTokenizer(bf.readLine());

        // 순서가 보장되는 LinkedHashMap 선언
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());

            // 만약 hashMap에 키가 존재하다면 기존 값의 +1
            if (map.containsKey(k)) {
                int v = map.get(k);
                map.put(k, v + 1);
                // 최대 개수인지 확인
                if (v + 1 > MAX_COUNT)
                    MAX_COUNT = v + 1;
            } else
                map.put(k, 1);
        }

        // 최대 개수부터 최저개수까지 출력!
        for (int i = MAX_COUNT; i >= 1; i--) {
            for (int k : map.keySet()) {
                if (map.get(k) == i) {
                    for (int j = 0; j < i; j++)
                        bw.write(k + " ");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}