package me.iseunghan.programmers;

import java.util.StringTokenizer;

public class Coding_Test {
    public int solution(int n, String[] customers) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(customers[i]);
            //KIOSK kiosk = new KIOSK(i, customers[i - 1]);
        }



        return answer;
    }
    class KIOSK {
        int SERIAL_NUMBER = 0;
        int DATE =0;
        int TIME = 0;

        public KIOSK(int SERIAL_NUMBER, int DATE, int TIME) {
            this.SERIAL_NUMBER = SERIAL_NUMBER;
            this.DATE = DATE;
            this.TIME = TIME;
        }

        public int getDATE() {
            return DATE;
        }

        public void setDATE(int DATE) {
            this.DATE = DATE;
        }

        public int getTIME() {
            return TIME;
        }

        public void setTIME(int TIME) {
            this.TIME = TIME;
        }
    }
}
