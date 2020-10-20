package me.iseunghan.baekjoon;

import java.io.*;

public class Bee_House_2292 {
    public static void main(String[] args) throws IOException {
        int answer = 1;
        int count = 1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        while (count < N) {
            count += 6 * (answer++);
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
