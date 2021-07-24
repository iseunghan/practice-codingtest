package me.iseunghan.baekjoon.정렬;

import java.io.*;

public class 수정렬하기4_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[2_000_002];   // 만약 -1000000가 입력된다면 +1000000을 더해서 arr[-1000000+1000000]에 값을 증가시켜준다.

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(bf.readLine()) + 1_000_000]++;   // *핵심* 인덱스는 음수일 수 없으므로, 1000000을 더해준 인덱스에 체크한다.
        }

        for (int i = arr.length-1; i >= 0; i--) {
            while (arr[i]-- > 0) {
                bw.write((i - 1_000_000) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
