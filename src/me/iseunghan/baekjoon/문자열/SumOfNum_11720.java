package me.iseunghan.baekjoon.문자열;

import java.io.*;

public class SumOfNum_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int length = Integer.parseInt(bf.readLine());
        String numbers = bf.readLine();

        for(int i=0; i<length;i++){
            answer += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        System.out.println(answer);
    }
}
