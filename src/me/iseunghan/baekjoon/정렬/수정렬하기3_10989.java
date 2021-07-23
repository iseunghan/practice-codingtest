package me.iseunghan.baekjoon.정렬;

import java.io.*;

public class 수정렬하기3_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[10001]; // 1부터 최대 숫자인 10000까지의 배열을 생성한다.

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(bf.readLine())]++; // 입력받은 수에 해당하는 배열의 값을 증가시킨다.
        }

        // 값을 입력받을 때, 해당 수를 배열의 인덱스로 하여 값을 증가시켰기 때문에 정렬이 된 셈이다.
        for(int i=1; i<=10000; i++){
            // 값이 있을 때, 그 값만큼 해당 인덱스를 출력시켜준다.
            while(arr[i]-- > 0){
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
