package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Dot_4th {
    static int[] xrr = new int[1001];
    static int[] yrr = new int[1001];

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i <= 2; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xrr[x]++;
            yrr[y]++;
        }
        for (int i = 1; i < xrr.length; i++) {
            if (xrr[i] == 1) {
                bw.write(i + " ");
                break;
            }
        }
        for (int i = 1; i < yrr.length; i++) {
            if (yrr[i] == 1) {
                bw.write(i + "");
                break;
            }
        }
        bw.flush();
        bw.close();
    }

}