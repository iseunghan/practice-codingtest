package me.iseunghan.baekjoon.정렬2;

import java.util.*;
import java.io.*;

public class 접미사배열_11656 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();
        String[] arr = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);

        for (String i : arr) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}