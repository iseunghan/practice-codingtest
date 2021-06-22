package me.iseunghan.programmers.고득점Kit.정렬;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(int[] numbers) {
            //int[] to String[]
            String[] num_String = this.intToString(numbers);
            //정렬
            Arrays.sort(num_String, new Comparator<String>() {
                public int compare (String s1, String s2){
                    return (s2+s1).compareTo(s1+s2);
                }
            });

            if(num_String[0].equals("0")) return "0";

            //answer에 저장.
            String answer = "";
            for(String s : num_String){
                answer += s;
            }
            return answer;
        }

        //int[] to String[]
        private String[] intToString(int[] numbers){
            String[] num_String = new String[numbers.length];
            for(int i=0; i<numbers.length; i++){
                num_String[i] = String.valueOf(numbers[i]);
            }
            return num_String;
        }
    }
}
