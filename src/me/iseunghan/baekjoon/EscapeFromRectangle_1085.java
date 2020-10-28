package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class EscapeFromRectangle_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = Math.min(w - x, Math.min(h - y, Math.min(x, y)));
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}