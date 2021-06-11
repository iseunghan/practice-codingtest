package me.iseunghan.baekjoon.스택;

import java.util.*;
import java.io.*;

// 안정적인 문자열 4889번 문제
public class BOJ_4889 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> st = new Stack<>();

        String s = bf.readLine();
        int k = 0;
        while(!s.substring(0,1).equals("-")){
            int result = 0;

            String[] arr = s.split("");

            for(int i=0; i<arr.length; i++){
                switch (arr[i]){
                    case "{":
                        st.push("{");
                        break;
                    case "}":
                        if(!st.isEmpty() && st.peek().equals("{")){
                            st.pop();
                        }else{
                            result++;
                            st.push("{");
                        }
                        break;
                }
            }
            if(!st.isEmpty()){
                bw.write(++k + ". " + (result + (st.size() / 2)) + "\n");
            }else{
                bw.write(++k + ". " + result + "\n");
            }
            s = bf.readLine();    // 다시 입력 받기.
            st.clear();
        }
        bw.flush();
        bw.close();
    }
}
