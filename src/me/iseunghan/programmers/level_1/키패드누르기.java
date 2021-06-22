package me.iseunghan.programmers.level_1;

public class 키패드누르기 {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(int[] numbers, String hand) {
            StringBuffer sb = new StringBuffer();

            // 왼손, 오른손의 현재위치
            int LS = 10;
            int RS = 12;

            // 왼손과 오른손과 키패드의 거리를 계산하기 위한 좌표 변수들 생성
            int LS_X = 0, LS_Y = 0, RS_X = 0, RS_Y = 0, N_X = 0, N_Y = 0, distance_L = 0, distance_R = 0;

            // 키패드 입력 시작
            for (int i = 0; i < numbers.length; i++) {
                switch (numbers[i]) {
                    case 1:
                    case 4:
                    case 7:
                        LS = numbers[i];
                        sb.append("L");
                        break;
                    case 3:
                    case 6:
                    case 9:
                        RS = numbers[i];
                        sb.append("R");
                        break;
                    default:
                        // numbers[i] 좌표 계산
                        if (numbers[i] == 0) {
                            N_X = 3;
                            N_Y = 2;
                        } else if (numbers[i] % 3 == 0) {
                            N_X = numbers[i] / 3 - 1;
                            N_Y = 3;
                        } else {
                            N_X = numbers[i] / 3;
                            N_Y = numbers[i] % 3;
                        }

                        // 현재 왼손의 좌표 계산
                        if (LS == 0) {
                            LS_X = 3;
                            LS_Y = 2;
                        } else if (LS % 3 == 0) {
                            LS_X = LS / 3 - 1;
                            LS_Y = 3;
                        } else {
                            LS_X = LS / 3;
                            LS_Y = LS % 3;
                        }

                        // 현재 오른손의 좌표 계산
                        if (RS == 0) {
                            RS_X = 3;
                            RS_Y = 2;
                        } else if (RS % 3 == 0) {
                            RS_X = RS / 3 - 1;
                            RS_Y = 3;
                        } else {
                            RS_X = RS / 3;
                            RS_Y = RS % 3;
                        }

                        // 왼손과 오른손의 거리 계산
                        distance_R = Math.abs(N_X - RS_X) + Math.abs(N_Y - RS_Y);
                        distance_L = Math.abs(N_X - LS_X) + Math.abs(N_Y - LS_Y);

                        // 거리 비교
                        if (distance_L < distance_R) {
                            sb.append("L");
                            LS = numbers[i];
                        } else if (distance_L > distance_R) {
                            sb.append("R");
                            RS = numbers[i];
                        } else {
                            if (hand.equals("right")) {
                                sb.append("R");
                                RS = numbers[i];
                            } else {
                                sb.append("L");
                                LS = numbers[i];
                            }
                        }
                        break;
                }
            }

            return sb.toString();
        }
    }
}
