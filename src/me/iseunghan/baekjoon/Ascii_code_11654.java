package me.iseunghan.baekjoon;

import java.io.*;

public class Ascii_code_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char asc = bf.readLine().charAt(0);
        int ascToInt = (int)asc;
        System.out.println(ascToInt);
    }
}
