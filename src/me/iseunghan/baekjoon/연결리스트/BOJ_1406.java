package me.iseunghan.baekjoon.연결리스트;

import java.util.*;
import java.io.*;

public class BOJ_1406 {
    static int cursor = 0;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine();
        LinkedList<String> list = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            list.add(str.substring(i, i+1));
        }
        int N = Integer.parseInt(bf.readLine());

        // ListIterator는 Iterator를 상속받는다.
        ListIterator<String> iter = list.listIterator();
        // 마지막까지 커서를 이동시켜준다. ex.(ABCD|)
        while(iter.hasNext()){
            iter.next();
        }

        for(int i=0; i<N; i++){
            String a = bf.readLine();
            if(a.equals("L")){
                // 커서를 왼쪽으로
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }else if(a.equals("D")){
                // 커서를 오른쪽으로
                if(iter.hasNext()){
                    iter.next();
                }
            }else if(a.equals("B")){
                // 커서 왼쪽 문자 삭제
                if(iter.hasPrevious()){
                    // 삭제는 오른쪽을 삭제하기 때문에 왼쪽으로 이동 후 삭제!
                    iter.previous();    // 커서 이전으로 이동 후
                    iter.remove();      // 삭제!
                }
            }else {
                // 문자 삽입
                iter.add(a.substring(2));
                // 삽입 후 커서 자동으로 마지막으로 감.
            }
        }

        for (String s : list)
            bw.write(s);

        bw.flush();
        bw.close();
    }
}