package me.iseunghan.baekjoon.문자열;

import java.io.*;

public class Croatia_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] croatians = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String alphabet = bf.readLine();
        int answer = 0;

        for (int i = 0; i < croatians.length; i++) {
            if (alphabet.contains(croatians[i])) { // 크로아티아 알파벳이 포함?
//                answer++;
                alphabet = alphabet.replace(croatians[i], "/");
            }
        }
//        String s = alphabet.replaceAll("/", "");
        answer += alphabet.length();
        System.out.println(answer);
    }
}
