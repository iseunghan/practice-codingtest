package me.iseunghan.programmers.level_3;

import java.util.*;

public class 퍼즐조각채우기 {

    static class Solution {
        static int answer;
        static int[] dx;
        static int[] dy;
        static int[][] table;
        static boolean[] visit_b;
        static boolean[] visit_t;
        static int[][] game_board;
        static ArrayList<int[][]> puzzle_list = new ArrayList<>();

        public int solution(int[][] game_board, int[][] table) {
            answer = 0;
            this.table = table;
            this.game_board = game_board;

            dx = new int[]{-1, 0, 1, 0};
            dy = new int[]{0, 1, 0, -1};

            // 게임 보드의 값을 0과 1을 서로 바꿔줍니다.
            for (int i = 0; i < game_board.length; i++) {
                for (int j = 0; j < game_board.length; j++) {
                    if (game_board[i][j] == 0)
                        game_board[i][j] = 1;
                    else
                        game_board[i][j] = 0;
                }
            }

            // 보드와 퍼즐을 추출해낸다.
            ArrayList<int[][]> list_b = find_puzzle(game_board);
            ArrayList<int[][]> list_t = find_puzzle(table);

            visit_b = new boolean[list_b.size()];
            visit_t = new boolean[list_t.size()];

            // 이제 두 리스트를 가지고 퍼즐을 맞춰본다.
            for (int i = 0; i < list_b.size(); i++) {

                // 이미 퍼즐을 채운 곳은 PASS!
                if (visit_b[i]) continue;

                int[][] target = list_b.get(i);
                int flag = 0;

                for (int j = 0; j < list_t.size(); j++) {
                    // 이미 사용한 퍼즐은 PASS!
                    if (visit_t[j]) continue;


                    int[][] puzzle = list_t.get(j);

                    for (int k = 0; k < 4; k++) {
                        // puzzle을 회전시킨다. 다시 puzzle에 넣어준다!
                        puzzle = rotate_puzzle(puzzle);

                        // 퍼즐을 맞추는데 성공했다면? 해당 타켓과 퍼즐을 제외시키고 PASS
                        if (attach_puzzle(target, puzzle)) {
                            flag = 1;

                            visit_b[i] = true;
                            visit_t[j] = true;

                            break;
                        }

                    }

                    if (flag == 1) {
                        break;
                    }
                }
            }
            // System.out.println(answer);

            return answer;
        }

        // 퍼즐을 맞춰보는 메소드
        public boolean attach_puzzle(int[][] target, int[][] puzzle) {
            // 0. 변수 선언
            int cnt_puz = 0;    // 퍼즐의 1 카운트
            int cnt_tar = 0;    // 타켓의 1 카운트
            int cnt_not = 0;    // 서로 다른 값 카운트


            // 1. 먼저 가로 세로 길이 일치 확인!
            if (target.length != puzzle.length || target[0].length != puzzle[0].length) {
                return false;
            }

            // 2. 만약 길이가 같다면, target[i][j]가 1일 경우의 각각 1의 개수를 센다.
            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < target[0].length; j++) {
                    // (* 조건) 퍼즐이 타겟에 딱 맞으면 각 카운트 변수는 같을 것이다.
                    if (target[i][j] == 1) {
                        cnt_tar++;

                        if (puzzle[i][j] == 1) {
                            cnt_puz++;
                        }
                    }

                    if (target[i][j] != puzzle[i][j]) {
                        cnt_not++;
                    }
                }
            }

            // 정답이라면 target, puzzle은 다시 사용할 수 없다. answer에 채운 만큼 더해준다.
            if (cnt_puz == cnt_tar && cnt_not == 0) {
                answer += cnt_puz;
                return true;
            }

            return false;
        }

        // 퍼즐을 90도 방향으로 회전시켜주는 메소드
        public int[][] rotate_puzzle(int[][] puzzle) {
            // 가로, 세로 변경
            int R = puzzle[0].length;
            int C = puzzle.length;

            int[][] temp = new int[C][R];

            for (int i = 0; i < C; i++) {
                for (int j = 0; j < R; j++) {
                    temp[i][j] = puzzle[i][j];
                }
            }

            puzzle = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    puzzle[i][j] = temp[C - 1 - j][i];
                }
            }

            return puzzle;
        }

        // 해당 배열을 돌면서 딱 맞는 퍼즐이나 퍼즐을 끼울 수 있는 공간을 추출해낸다.
        public ArrayList<int[][]> find_puzzle(int[][] target) {
            // bfs를 이용해서 퍼즐 조각 뽑아내기
            ArrayList<int[][]> a_list = new ArrayList<>();
            Queue<int[]> qu = new LinkedList<>();

            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < target.length; j++) {
                    if (target[i][j] == 1) {
                        ArrayList<int[]> list = new ArrayList<>();
                        int mX = 51;
                        int mY = 51;

                        mX = Math.min(mX, i);
                        mY = Math.min(mY, j);

                        target[i][j] = 0;
                        qu.offer(new int[]{i, j});
                        list.add(new int[]{i, j});

                        while (!qu.isEmpty()) {
                            int[] a = qu.poll();

                            for (int p = 0; p < 4; p++) {

                                int nX = a[0] + dx[p];
                                int nY = a[1] + dy[p];

                                if (nX < 0 || nX >= target.length || nY < 0 || nY >= target.length) continue;
                                if (target[nX][nY] == 0) continue;

                                target[nX][nY] = 0;
                                mX = Math.min(mX, nX);
                                mY = Math.min(mY, nY);
                                qu.offer(new int[]{nX, nY});
                                list.add(new int[]{nX, nY});
                            }
                        }
                        a_list.add(save_arranged_puzzle(list, mX, mY));
                    }
                }
            }
            return a_list;
        }

        // 퍼즐을 왼쪽 상단으로 정렬시킨다.
        public int[][] save_arranged_puzzle(ArrayList<int[]> list, int mX, int mY) {
            int max_X = 0;
            int max_Y = 0;

            // arrange to zero
            for (int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);

                arr[0] -= mX;
                arr[1] -= mY;

                max_X = Math.max(max_X, arr[0]);
                max_Y = Math.max(max_Y, arr[1]);

                list.set(i, arr);
            }

            // create array
            int[][] puzzle = new int[max_X + 1][max_Y + 1];

            for (int[] a : list) {
                if (a[0] < 0 || a[1] < 0) {
                    System.out.println("!");
                    continue;
                }
                puzzle[a[0]][a[1]] = 1;
            }

            return puzzle;
        }
    }
}
