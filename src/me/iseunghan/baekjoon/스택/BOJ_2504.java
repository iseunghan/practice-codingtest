package me.iseunghan.baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0, cnt_4 = 0;
        String[] arr = bf.readLine().split("");
        Stack<String> st = new Stack<>();
        int result = 0;

        for(int i=0; i<arr.length; i++){
            switch(arr[i]){
                case "(":           // 괄호 시작 (, [ 는 그냥 바로 push 한다.
                    cnt_1++;
                    st.push(arr[i]);
                    break;
                case ")":
                    cnt_2++;
                    if(st.size() > 0){              // 스택 사이즈 체크
                        if(st.peek().equals("(")){  // 만약 ( 가 있다면 바로 합쳐서 2를 다시 스택에 넣는다.
                            st.pop();
                            st.push("2");
                        }else{
                            int num = 0;
                            while(!st.isEmpty()){
                                // 스택의 값을 뽑으면서 숫자면 -> 더하고, 결국에 괄호의 짝을 찾았을 경우에 곱해서 스택에 넣어준다.
                                String p = st.pop();
                                if(p.equals("(")){
                                    // 짝을 만났으므로 곱셈 후 다시 스택에 넣는다.
                                    num = num * 2;
                                    st.push(String.valueOf(num));
                                    break;
                                }else if(p.equals("[") || p.equals("]")){
                                    // 짝이 없는 괄호를 만나면 종료.
                                    System.out.print(0);
                                    System.exit(0);
                                }else{
                                    // 숫자를 만나면 더해준다.
                                    num += Integer.parseInt(p);
                                }
                            }
                        }
                    }else{
                        System.out.print(0);
                        System.exit(0);
                    }
                    break;
                case "[":           // 괄호 시작 (, [ 는 그냥 바로 push 한다.
                    cnt_3++;
                    st.push(arr[i]);
                    break;
                case "]":
                    cnt_4++;
                    if(st.size() > 0){
                        if(st.peek().equals("[")){
                            st.pop();
                            st.push("3");
                        }else{
                            int num = 0;
                            while(!st.isEmpty()){
                                // 스택의 값을 뽑으면서 숫자면 -> 더하고, 결국에 괄호의 짝을 찾았을 경우에 곱해서 스택에 넣어준다.
                                String p = st.pop();
                                if(p.equals("[")){
                                    // 짝을 만났으므로 곱셈 후 다시 스택에 넣는다.
                                    num = num * 3;
                                    st.push(String.valueOf(num));
                                    break;
                                }else if(p.equals("(") || p.equals(")")){
                                    // 만약 짝이 없는 괄호가 있다면 바로 종료.
                                    System.out.print(0);
                                    System.exit(0);
                                }else{
                                    // 숫자가 나오면 더해준다.
                                    num += Integer.parseInt(p);
                                }
                            }
                        }
                    }else{
                        System.out.print(0);
                        System.exit(0);
                    }
                    break;
                default:    // (,),[,] 외 문자열이 들어오면 바로 종료.
                    System.out.print(0);
                    System.exit(0);
                    break;
            }
        }

        if((cnt_1 != cnt_2) || (cnt_3 != cnt_4)){   // 괄호 짝이 안맞으면 0 츌력.
            System.out.print(0);
        }else{
            while(!st.isEmpty()){   // 스택에 있는 숫자들을 다 더해서 출력.
                result += Integer.parseInt(st.pop());
            }
            System.out.print(result);
        }
    }
}