package week01.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * baekjoon 9093 단어 뒤집기
 *
 * */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(c);
                }
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
