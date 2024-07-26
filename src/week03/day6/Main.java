package week03.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * baekjoon 2661 좋은수열
 *
 * */

public class Main {
    private static final char[] oneTwoThree = {'1', '2', '3'};
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtrack(0, new StringBuilder());
    }

    private static boolean isGood(StringBuilder current) {
        int len = current.length();

        for (int i = 1; i <= len / 2; i++) {
            if (current.substring(len - i).equals(current.substring(len - i * 2, len - i))) {
                return false;
            }
        }
        return true;
    }

    public static void backtrack(int depth, StringBuilder current) {
        if (depth == N) {
            System.out.println(current);
            System.exit(0);
        }

        for (int i = 0; i < 3; i++) {
            current.append(oneTwoThree[i]);
            if (isGood(current)) {
                backtrack(depth + 1, current);
            }
            current.deleteCharAt(current.length() - 1);
        }

    }
}
