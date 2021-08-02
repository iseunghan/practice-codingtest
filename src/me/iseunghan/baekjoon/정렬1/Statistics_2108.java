package me.iseunghan.baekjoon.정렬1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Statistics_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        ArrayList<Integer> numlist = new ArrayList<>(); // 최빈 값 넣기
        int[] count = new int[8002];
        int sum = 0;
        int count_max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            count[arr[i] + 4000]++;
            sum += arr[i];

            if (count[arr[i] + 4000] > count_max) {
                count_max = count[arr[i] + 4000];
            }
        }

        Arrays.sort(arr);

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == count_max) {
                numlist.add(i - 4000);
            }
        }
        int manyNum = 0; // 3번째 최빈값

        if (numlist.size() == 1) {
            //System.out.println(numlist.get(0));
            manyNum = numlist.get(0);
        } else {
            //System.out.println(numlist.get(numlist.size()-2));
            manyNum = numlist.get(numlist.size() - 2);
        }

//        for (Integer integer : numlist) {
//            System.out.println(integer);
//        }
        // sum
        int average = (int) Math.rint((sum / (N * 1.0))); // 1번째 산술 평균
        int middle = arr[N / 2]; // 2번째 중앙값
        int MAX = arr[N - 1];
        int MIN = arr[0];
        int range = 0;

        if (N != 1) {
            range = MAX + Math.abs(MIN); // 4번째 : 범위
        }

        System.out.print(average + "\n" + middle + "\n" + manyNum + "\n" + range);


    }
}