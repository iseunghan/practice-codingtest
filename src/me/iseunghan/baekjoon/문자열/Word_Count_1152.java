package me.iseunghan.baekjoon.문자열;

import java.io.*;
import java.util.StringTokenizer;

public class Word_Count_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(bf.readLine());
//        bw.write(st.countTokens() + ""); // Token의 개수가 곧 정답이다.
        String[] arr = bf.readLine().split(" ");
        bw.write(arr.length + "");
        bw.flush();
        bw.close();
    }
}
