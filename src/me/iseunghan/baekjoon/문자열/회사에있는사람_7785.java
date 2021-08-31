package me.iseunghan.baekjoon.문자열;

import java.util.*;
import java.io.*;

public class 회사에있는사람_7785 {
    public static void main(String args[]) throws IOException {
        StringTokenizer st;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Boolean> map = new HashMap<>();
        int N = Integer.parseInt(bf.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = "0";   // null 방지 초기화
            st = new StringTokenizer(bf.readLine());

            map.put(st.nextToken(), st.nextToken().equals("enter"));
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (String name : map.keySet()) {
            if (map.get(name)) {
                arr[idx++] = name;
            }
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 마지막 부터 출력
        for (int i = N - 1; i >= 0; i--) {
            if (!arr[i].equals("0")) {
                bw.write(arr[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}