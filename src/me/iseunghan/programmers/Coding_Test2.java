package me.iseunghan.programmers;

import java.util.StringTokenizer;

public class Coding_Test2 {
    public String solution(String p, int n) {
        String answer = "";

        StringTokenizer st = new StringTokenizer(p);
        String D = st.nextToken();
        String T = st.nextToken();
        String[] split = T.split(":");
        int H = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int S = Integer.parseInt(split[2]);

        // 24Hour 변환
        if (D.equals("AM")) {

        } else if (D.equals("PM")) {
            H += 12;
            if (H >= 24) {
                H = 0;
            }
        }

        // N초를 각각 몇 시간, 몇 분, 몇 초 인지 구하기
        if (n >= 60) {
            int s = n % 60;
            S += s;
            n /= 60;
            if (n >= 60) {
                int m = n % 60;
                M += m;
                H += n / 60;
            }else{
                M += n;
            }
        }else{
            S += n;
        }

        // n 초 더해주기
        if (S >= 60) {
            S -= 60;
            M += 1;
            if (M >= 60) {
                M -= 60;
                H += 1;
                while(H >= 24) {
                    H -= 24;
                }
            }
        }

        //이제 문자열로 변환
        if (H < 10) {
            answer += "0" + H;
        } else {
            answer += H;
        }
        answer += ":";
        if (M < 10) {
            answer += "0" + M;
        } else {
            answer += M;
        }
        answer += ":";
        if (S < 10) {
            answer += "0" + S;
        } else {
            answer += S;
        }

        return answer;
    }
}
