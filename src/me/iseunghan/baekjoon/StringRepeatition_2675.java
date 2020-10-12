package me.iseunghan.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class StringRepeatition_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String answer;

        int T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++){
            answer = getString(bf);
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        bf.close();
    }

    private static String getString(BufferedReader bf) throws IOException {
        StringTokenizer st;
        String answer;
        st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        String S = st.nextToken();
        answer = "";
        for(int k=0; k<S.length(); k++) {
            for (int j = 0; j < R; j++) {
                answer += S.charAt(k);
            }
        }
        return answer;
    }
}
