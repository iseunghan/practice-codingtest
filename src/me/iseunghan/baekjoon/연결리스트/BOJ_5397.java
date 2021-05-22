package me.iseunghan.baekjoon.연결리스트;

import java.util.*;
import java.io.*;

/**
 * 연결리스트 - 키로거 5397번 문제
 * 핵심: LinkedList의 ListIterator를 활용!
 */
public class BOJ_5397{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        LinkedList<String> list = new LinkedList<>();
        ListIterator<String> iter = list.listIterator();

        for(int i=0; i<N; i++){
            String password = bf.readLine();
            int count = 0;

            for(int j=0; j<password.length(); j++){
                String a = password.substring(j, j+1);
                switch (a){
                    case "<":
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case ">":
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    case "-":
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(a);
                        count++;
                        break;
                }
            }
            while(iter.hasPrevious()){
                iter.previous();
            }
            while(iter.hasNext()){
                bw.write(iter.next() + "");
                iter.previous();
                iter.remove();
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
    }
}